package Tree

import IVisitor.JsonObject
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.*
import java.io.File
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex

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
        var a = TreeItem(tree, SWT.NONE)
        a.text = "joson"
        a.data = joson
        // criar a arvore com workitem
        popularTreeItem(joson, a)
        tree.expandAll()
        shell.pack()
        shell.open()
        val display = Display.getDefault()
        while (!shell.isDisposed) {
            if (!display.readAndDispatch()) display.sleep()
        }
        display.dispose()
    }

    fun popularTreeItem(joson : JsonObject, t : TreeItem){
        var newRoot = TreeItem(t, SWT.NONE)
        newRoot.text = "(object)"
        newRoot.data = joson

        /*if (file.isDirectory){
            file.listFiles().forEach {
                popularTreeItem(it, newRoot)
            }
        }*/
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