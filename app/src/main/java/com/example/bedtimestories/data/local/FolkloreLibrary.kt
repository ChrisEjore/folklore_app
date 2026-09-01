package com.example.bedtimestories.data.local

data class SampleStory(
    val id: String,
    val title: String,
    val origin: String,
    val category: String,
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
            readTime = "6 min read",
            summary = "The story of the Luo hero whose invincible strength was hidden in his shadow.",
            iconEmoji = "🛡️",
            content = """
Long ago, near the shores of Nyanza (Lake Victoria), lived a legendary hero of the Kano clan named Luanda Magere. He possessed immense strength and courage. During battles between the Luo and the neighboring Nandi people, Luanda Magere was an unstoppable warrior. Spear blades and arrows simply bent or shattered whenever they struck his skin.

Because he could not be harmed, the Luo people won every battle he fought in. The opposing warriors grew terrified, wondering what secret protected this invincible defender. 

Seeking peace and hoping to discover his secret, the elders of the enemy offered Luanda Magere a princess in marriage. Despite warnings from his elders, Magere accepted her into his home.

For a long time, the secret remained safe. But one day, Luanda Magere fell ill with a severe fever. Unable to leave his hut, he instructed his new wife to cut his shadow with a traditional blade and rub medicinal herbs into the mark. As she struck his shadow, to her astonishment, real blood trickled from it. His body was made of solid rock, but his life force and physical vulnerability resided entirely within his shadow.

The wife quietly slipped away at night and brought this secret back to her people. In the very next battle, an enemy warrior stood at a distance, ignored Magere's granite body, and hurled a spear straight into his shadow on the dusty ground. 

Luanda Magere fell to the earth and transformed into a grand rock near the River Awach. To this day, the stone of Luanda Magere remains a revered symbol of strength, unity, and heritage in Kenya.
            """.trimIndent()
        ),
        SampleStory(
            id = "hare_and_hyena",
            title = "The Clever Hare & The Greedy Hyena",
            origin = "East African Trickster Tale",
            category = "African Folklore",
            readTime = "4 min read",
            summary = "Sungura the Hare uses his quick wits to outsmart the greedy Hyena during a drought.",
            iconEmoji = "🐇",
            content = """
Once upon a time, during a season of great drought across the savannah, food became scarce for all animals. Sungura the Hare and his neighbor Hyena decided to travel together to search for food in the highlands beyond the hills.

After hours of walking, Sungura spotted a rich honeycomb hanging high in a baobab tree. Hyena, driven by his relentless greed, rushed forward and insisted on taking the largest share for himself before Sungura could even reach the tree.

"I am bigger and stronger!" declared Hyena. "I will climb up and throw down only what I choose not to eat."

Sungura smiled calmly and agreed. As Hyena climbed into the hollow of the tree and began gobbling down the sweet honey, he carelessly disturbed a massive nest of wild bees. 

Realizing what was happening, Sungura quickly called out from below: "Friend Hyena! Tie this heavy leather strap around your waist so I can pull you down safely if the bees attack!" 

Hyena eagerly tied the strap to himself and tossed the end down. Instead of holding it, Sungura securely tied the strap to a heavy root and slipped away into the tall grass. When the bees swarmed out, Hyena jumped from the branch—only to bounce in mid-air and get stuck dangling upside down!

Hyena learned a hard lesson about greed and fairness, while clever Sungura returned home safely to enjoy his own well-earned harvest.
            """.trimIndent()
        ),
        SampleStory(
            id = "anansi_spider",
            title = "Anansi and the Pot of Wisdom",
            origin = "Ashanti / West Africa",
            category = "African Folklore",
            readTime = "4 min read",
            summary = "Anansi tries to keep all the world's wisdom in a calabash top high in a tree.",
            iconEmoji = "🕷️",
            content = """
Long ago, Kwaku Anansi the Spider possessed all the wisdom of the world. However, Anansi was stingy and did not want to share any knowledge with the rest of the villagers. He decided to gather every piece of wisdom into a large clay calabash pot and hide it at the top of the highest silk-cotton tree in the forest.

He tied the heavy pot to his stomach and began trying to climb the tall tree. But having the bulky pot strapped right in front of him made it impossible to grip the trunk or step up the branches. He slipped and fell back down over and over again.

His young son, Ntikuma, had secretly followed him into the woods and watched his father struggle. Ntikuma stepped out from behind a bush and called out gently: 

"Father, wouldn't it be much easier to climb if you tied the pot of wisdom onto your back instead of your stomach?"

Anansi stopped and thought about it. He moved the pot to his back and immediately climbed the tree with ease. But as he reached the upper branches, he realized that his young son had possessed a piece of wisdom that he himself had lacked.

Frustrated that he could not own *all* wisdom, Anansi dropped the calabash in anger. It shattered on the roots below, and a gust of wind scattered the bits of wisdom to every corner of the earth. That is why today, wisdom belongs to everyone everywhere, rather than just one person.
            """.trimIndent()
        ),
        SampleStory(
            id = "tortoise_birds",
            title = "Why Tortoise Has a Cracked Shell",
            origin = "Igbo Folktale",
            category = "African Folklore",
            readTime = "4 min read",
            summary = "Tortoise borrows feathers to attend a feast in the clouds, but his vanity costs him.",
            iconEmoji = "🐢",
            content = """
A long time ago, there was a great famine in the animal kingdom, but the birds were invited to a grand feast hosted by the Sky People. Tortoise, who was sharp-tongued and extremely hungry, persuaded the birds to let him join them. 

Since he had no wings, each bird generously donated one feather to him. Tortoise crafted a splendid pair of wings and flew up into the clouds along with the flock.

Before arriving, Tortoise suggested: "In high custom, when we arrive at a royal feast, we must all take new ceremonial names." The birds agreed. Tortoise announced, "My name for today shall be 'All-of-You'."

When the hosts presented enormous platters of steaming, fragrant food, they bowed and said, "This food is for *All of You*."

Tortoise stepped forward with a grin and reminded the birds: "You heard them—my name is 'All-of-You'! The food belongs to me." He ate until he could barely move, leaving only scraps for the birds.

Furious at his deceit, the birds reclaimed every single feather they had lent him and flew back down to earth, leaving Tortoise stranded in the sky. 

Tortoise begged Parrot to deliver a message to his wife on earth, asking her to lay down soft cushions around his house so he could jump down safely. Instead, the angry Parrot told his wife to pile up hard rocks and iron tools.

Tortoise leapt from the clouds and crashed onto the pile of rocks. A wise medicine man pieced his shell back together, which is why to this very day, every tortoise has a cracked, patchwork shell.
            """.trimIndent()
        )
    )
}