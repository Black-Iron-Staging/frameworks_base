/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settingslib.spa.screenshot.widget.preference

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AirplanemodeActive
import androidx.compose.runtime.Composable
import com.android.settingslib.spa.screenshot.util.settingsScreenshotTestRule
import com.android.settingslib.spa.widget.preference.SwitchPreference
import com.android.settingslib.spa.widget.preference.SwitchPreferenceModel
import com.android.settingslib.spa.widget.ui.SettingsIcon
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import platform.test.runner.parameterized.ParameterizedAndroidJunit4
import platform.test.runner.parameterized.Parameters
import platform.test.screenshot.DeviceEmulationSpec
import platform.test.screenshot.PhoneAndTabletMinimal

/** A screenshot test for ExampleFeature. */
@RunWith(ParameterizedAndroidJunit4::class)
class SwitchPreferenceScreenshotTest(emulationSpec: DeviceEmulationSpec) {
    companion object {
        @Parameters(name = "{0}")
        @JvmStatic
        fun getTestSpecs() = DeviceEmulationSpec.PhoneAndTabletMinimal
    }

    @get:Rule
    val screenshotRule =
        settingsScreenshotTestRule(
            emulationSpec,
        )

    @Test
    fun test() {
        screenshotRule.screenshotTest("switchPreference") {
            Column {
                SampleSwitchPreference()
                SampleSwitchPreferenceWithSummary()
                SampleNotChangeableSwitchPreference()
                SampleSwitchPreferenceWithIcon()
            }
        }
    }
}

@Composable
private fun SampleSwitchPreference() {
    SwitchPreference(object : SwitchPreferenceModel {
        override val title = "SwitchPreference"
        override val checked = { false }
        override val onCheckedChange = null
    })
}

@Composable
private fun SampleSwitchPreferenceWithSummary() {
    SwitchPreference(object : SwitchPreferenceModel {
        override val title = "SwitchPreference"
        override val summary = { "With summary" }
        override val checked = { true }
        override val onCheckedChange = null
    })
}

@Composable
private fun SampleNotChangeableSwitchPreference() {
    SwitchPreference(object : SwitchPreferenceModel {
        override val title = "SwitchPreference"
        override val summary = { "Not changeable" }
        override val changeable = { false }
        override val checked = { true }
        override val onCheckedChange = null
    })
}

@Composable
private fun SampleSwitchPreferenceWithIcon() {
    SwitchPreference(object : SwitchPreferenceModel {
        override val title = "SwitchPreference"
        override val checked = { true }
        override val onCheckedChange = null
        override val icon = @Composable {
            SettingsIcon(imageVector = Icons.Outlined.AirplanemodeActive)
        }
    })
}
