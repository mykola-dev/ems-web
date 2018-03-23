package app

import org.w3c.dom.events.Event

val Event.stringValue: String get() = this.target.asDynamic().value as String
val Event.intValue: Int get() = this.target.asDynamic().value as Int