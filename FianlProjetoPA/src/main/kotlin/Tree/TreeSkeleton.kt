package Tree

import BuilderImpl.JsonObjectBuilderImpl
import IVisitor.*
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.*

class TreeSkeleton {
    val shell: Shell
    val tree: Tree

    init {
        shell = Shell(Display.getDefault())
        shell.setSize(250, 200)
        shell.text = "Tree skeleton"
        shell.layout = GridLayout(1,false)
        // o tree é o filho e Shell o pai
        tree = Tree(shell, SWT.SINGLE or SWT.BORDER)

        val label = Label(shell, SWT.NONE)
        label.text = "skeleton"
        tree.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                val item = tree.selection.first()
                label.text = item.depth().toString()
            }
        })

        val button = Button(shell, SWT.PUSH)
        button.text = "open"
        button.addSelectionListener(object: SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                val item = tree.selection.first()
                item.expanded
                shell.pack()
                shell.open()
                shell.isEnabled = true
                shell.requestLayout()
                val display = Display.getDefault()
                while (!shell.isDisposed) {
                    if (!display.readAndDispatch()) display.sleep()
                }
                display.dispose()
            }
        })

    }

    // auxiliar para profundidade do nó
    fun TreeItem.depth(): Int =
        if(parentItem == null) 0
        else 1 + parentItem.depth()

    fun open(joson : JsonObject) {

        var counter : Int = 0
        var treeItem = TreeItem(tree, SWT.NONE)
        treeItem.text = "(Object)"
        treeItem.data = joson
        // criar a arvore com workitem
        popularTreeItem(joson, treeItem)
        tree.expandAll()
        shell.pack()
        shell.open()

        val display = Display.getDefault()
        while (!shell.isDisposed) {
            if (!display.readAndDispatch()) display.sleep()
        }
        display.dispose()
    }

    fun popularTreeItem(joson : JsonObject, treeItem : TreeItem){

        val visitor = object : Visitor {
            var current = treeItem

            override fun visit(var1: JsonString) {
                var newRoot = TreeItem(current, SWT.NONE)
                newRoot.text = "(children)"
                newRoot.data = var1
            }
            override fun visit(var1: JsonNumber) {
                var newRoot = TreeItem(current, SWT.NONE)
                newRoot.text = "(children)"
                newRoot.data = var1

            }
            override fun visit(var1: JsonValue) {
                    var newRoot = TreeItem(current, SWT.NONE)
                    newRoot.text = "(children)"
                    newRoot.data = var1

            }

            override fun visit(var1 : JsonObject) : Boolean{
                var newRoot = TreeItem(current, SWT.NONE)
                newRoot.text = "(Object)"
                newRoot.data = var1 as JsonObjectBuilderImpl.JsonObjectImpl
                current = newRoot

                return true
            }
            override fun visit(var1 : JsonArray) : Boolean{
                var newRoot = TreeItem(current, SWT.NONE)
                newRoot.text = "(children)"
                newRoot.data = var1
                current = newRoot
                return true
            }

            override fun endVisit(c: JsonObject) {
                current = current.parentItem
            }
            override fun endVisit(c: JsonArray) {
                current = current.parentItem
            }
        }

        joson.accept(visitor)
    }

    fun Tree.expandAll() = traverse { it.expanded = true }

    fun Tree.traverse(visitor: (TreeItem) -> Unit) {
        fun TreeItem.traverse() {
            visitor(this)
            items.forEach {
                it.traverse()
            }
        }
        items.forEach { it.traverse() }
    }

}