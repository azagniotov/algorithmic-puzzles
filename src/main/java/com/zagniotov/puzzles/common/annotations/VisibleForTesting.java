package com.zagniotov.puzzles.common.annotations;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Annotation which is used just for documentary purpose and does not have any actionable consequence using it.
 * The annotation is ignored by the JVM. It annotates a program element that more widely visible than otherwise
 * necessary.
 */
@Retention(value = CLASS)
public @interface VisibleForTesting {

}
