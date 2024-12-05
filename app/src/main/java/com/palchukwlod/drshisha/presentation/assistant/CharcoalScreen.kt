package com.palchukwlod.drshisha.presentation.assistant

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shishamixcompouse.presentation.ui.theme.LARGE
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun CharcoalContent() {

    Scaffold {

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .padding(LARGE, bottom = 85.dp)) {

            item{
                Text(
                    modifier = Modifier.fillMaxWidth().padding(LARGE),
                    text = "Shisha Charcoal: The Essential Component for a Perfect Hookah Experience",
                    fontSize = 40.sp,
                    fontFamily = fontFamily,
                )
            }

            item {

                Text(
                    modifier = Modifier.padding(LARGE),
                    fontSize = 25.sp,
                    fontFamily = fontFamily,
                    text = "Shisha charcoal, also known as hookah charcoal, is a critical element in the world of hookah smoking. It's the heat source that ignites the flavored tobacco, known as shisha, allowing it to produce the rich, aromatic smoke enjoyed by enthusiasts worldwide. Choosing the right shisha charcoal can significantly impact the quality of your hookah session, making it essential to understand the different types available and their unique characteristics.\n" +
                            "\n" +
                            "Types of Shisha Charcoal\n" +
                            "Quick-Light Charcoal: This type is favored for its convenience. It lights up quickly with a simple lighter or match and is ready to use within a minute. Quick-light charcoal often contains chemicals that aid in the ignition process, which can sometimes affect the flavor of the shisha. Despite this, it's a popular choice for those who want a hassle-free setup.\n" +
                            "\n" +
                            "Natural Charcoal: Made from natural materials such as coconut shells, bamboo, or wood, natural charcoal is preferred by many hookah enthusiasts for its clean burn and minimal impact on the shisha's flavor. It takes longer to light than quick-light charcoal and requires a stove or burner, but the resulting experience is often worth the extra effort. Natural charcoal burns longer and provides a more consistent heat, enhancing the overall hookah session.\n" +
                            "\n" +
                            "Selecting the Right Charcoal\n" +
                            "When choosing shisha charcoal, consider the following factors:\n" +
                            "\n" +
                            "Burn Time: Natural charcoal typically offers a longer burn time, which means fewer interruptions to replace the coals.\n" +
                            "Flavor Preservation: For those who prioritize the pure taste of their shisha, natural charcoal is the preferred option due to its lack of chemical additives.\n" +
                            "Convenience: If you're looking for a quick setup and don't mind a slight compromise on flavor, quick-light charcoal is a practical choice.\n" +
                            "Preparing Shisha Charcoal\n" +
                            "Properly preparing your shisha charcoal is essential for an enjoyable smoking experience. Here are some tips:\n" +
                            "\n" +
                            "Lighting Natural Charcoal: Use a stove, charcoal burner, or an electric coil burner. Place the charcoal pieces on the burner and turn them periodically until they are fully lit and glowing red. This process usually takes about 5-10 minutes.\n" +
                            "Lighting Quick-Light Charcoal: Hold a piece with tongs and apply a lighter or match until it sparks and ignites. Allow it to turn fully red before placing it on the hookah bowl, which takes about 1-2 minutes.\n" +
                            "Safety Tips\n" +
                            "Always use tongs to handle hot charcoal.\n" +
                            "Ensure proper ventilation when lighting charcoal indoors.\n" +
                            "Dispose of used charcoal responsibly, ensuring it is fully extinguished to prevent fire hazards."
                )
            }


        }

    }

}