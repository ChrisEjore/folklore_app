package com.example.bedtimestories.data.local

data class SampleStory(
    val id: String,
    val title: String,
    val origin: String,
    val category: String, // e.g., "African Folklore", "Custom Parent Story"
    val readTime: String,
    val summary: String,
    val iconEmoji: String,
    val content: String
)

object FolkloreLibrary {
    val stories = listOf(
        SampleStory(
            id = "luanda_magere",
            title = "Luanda Magere: The Mighty Warrior",
            origin = "Luo Legend (Kenya)",
            category = "African Folklore",
            readTime = "5 min read",
            summary = "The story of the hero whose strength was hidden in his shadow.",
            iconEmoji = "🛡️",
            content = "Long ago along the shores of Lake Victoria lived Luanda Magere..."
        ),
        SampleStory(
            id = "hare_and_hyena",
            title = "The Clever Hare & The Greedy Hyena",
            origin = "East African Trickster Tale",
            category = "African Folklore",
            readTime = "4 min read",
            summary = "Sungura the Hare outsmarts Hyena during a feast in the forest.",
            iconEmoji = "🐇",
            content = "Once upon a time when animals could talk, Sungura the Hare..."
        ),
        SampleStory(
            id = "anansi_spider",
            title = "Anansi and the Pot of Wisdom",
            origin = "Ashanti / West Africa",
            category = "African Folklore",
            readTime = "4 min read",
            summary = "Anansi tries to hide all the world's wisdom in a calabash top high in a tree.",
            iconEmoji = "🕷️",
            content = "Anansi the Spider collected all the wisdom in the world..."
        ),
        SampleStory(
            id = "tortoise_birds",
            title = "Why Tortoise Has a Cracked Shell",
            origin = "Igbo Folktale",
            category = "African Folklore",
            readTime = "3 min read",
            summary = "Tortoise borrows feathers to attend a feast in the clouds.",
            iconEmoji = "🐢",
            content = "The birds were invited to a grand feast in the sky..."
        )
    )
}