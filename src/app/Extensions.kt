package app

import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event

val Event.inputValue: String get() = (this.target as HTMLInputElement).value