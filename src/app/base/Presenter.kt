package app.base

abstract class Presenter {
    lateinit var view: View<*, *>
}