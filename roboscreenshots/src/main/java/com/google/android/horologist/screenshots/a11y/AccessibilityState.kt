/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.horologist.screenshots.a11y

import android.graphics.Rect

internal data class AccessibilityState(
    val width: Int,
    val height: Int,
    val elements: List<Element>
) {
    internal data class Element(
        val displayBounds: Rect,
        val touchBounds: Rect?,
        val text: List<String>?,
        val contentDescription: List<String>?,
        val stateDescription: String?,
        val onClickLabel: String?,
        val role: String?,
        val disabled: Boolean,
        val heading: Boolean,
        val customActions: List<CustomAction>?,
        val progress: Progress?
    )

    internal data class CustomAction(val label: String)

    internal data class Progress(
        val current: Float,
        val range: ClosedRange<Float>,
        val steps: Int,
        val hasAction: Boolean
    ) {
        override fun toString(): String {
            return "$current [$range] ${if (hasAction) "Action" else ""}"
        }
    }
}
