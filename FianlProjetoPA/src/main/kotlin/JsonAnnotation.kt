class JsonAnnotation {
    @Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY)
    annotation class MainObject()

    @Target(AnnotationTarget.PROPERTY)
    annotation class AttributeObject()

    @Target(AnnotationTarget.PROPERTY)
    annotation class AttributeArray()

}