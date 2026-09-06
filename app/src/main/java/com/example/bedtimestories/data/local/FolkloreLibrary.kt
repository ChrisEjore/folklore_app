package com.example.bedtimestories.data.local

import androidx.compose.runtime.mutableStateListOf

data class SampleStory(
    val id: String,
    val title: String,
    val origin: String,
    val category: String, // General region or culture
    val genre: String,    // Action, Adventure, Thriller, Horror, Romance
    val minAge: Int,      // Parental control age limit
    val readTime: String,
    val summary: String,
    val iconEmoji: String,
    val imageUrl: String, // Colorful image URL or resource path
    val content: String,
    val moralLesson: String? = null,
    val speechRate: Float = 1.0f,
    val pitch: Float = 1.0f,
    val audioPath: String? = null, // Path to recorded audio if available
    val isUserCreated: Boolean = false // Flag to track custom stories
)

object FolkloreLibrary {
    private val initialStories = listOf(
        // --- ACTION ---
        SampleStory(
            id = "luanda_magere",
            title = "Luanda Magere: The Mighty Warrior",
            origin = "Luo Legend (Kenya)",
            category = "African Folklore",
            genre = "Action",
            minAge = 8,
            readTime = "12 min read",
            summary = "The story of the Luo hero whose invincible strength was hidden in his shadow.",
            iconEmoji = "🛡️",
            imageUrl = "https://images.unsplash.com/photo-1518709268805-4e9042af9f23?q=80&w=400",
            content = """
Long ago, near the shores of Nyanza (Lake Victoria), lived a legendary hero of the Kano clan named Luanda Magere. He possessed skin as tough as stone, and no weapon could pierce his body.
[img:https://images.unsplash.com/photo-1518709268805-4e9042af9f23?q=80&w=400]
For many years, Luanda Magere protected his people from the Lang'o warriors. He was like a one-man army, charging into battle with his heavy spear and shield, laughing as arrows bounced off his chest. The Kano clan prospered under his protection, and his name was whispered with fear across the lands.
[img:https://images.unsplash.com/photo-1589182373726-e4f658ab50f0?q=80&w=400]
But strength often comes with a secret. The Lang'o people, tired of defeat, decided to use cunning instead of force. They sent their most beautiful princess to be Luanda's wife, hoping she would discover the source of his power. One day, when Luanda fell ill, he told her: "My strength is not in my body, but in my shadow. If you must treat me, cut only the shadow."
[img:https://images.unsplash.com/photo-1490730141103-6cac27aaab94?q=80&w=400]
The princess betrayed him. During the next battle, the Lang'o warriors aimed their spears not at Luanda, but at the shadow stretched across the dusty ground. As a spear pierced the dark silhouette, blood gushed from Luanda's body. He fell, turning into a massive stone that remains by the lakeside to this day, a reminder of the hero who was betrayed.
            """.trimIndent(),
            moralLesson = "Pride and misplaced trust can lead even the strongest to their downfall.",
            speechRate = 0.9f,
            pitch = 0.8f
        ),
        SampleStory(
            id = "shaka_zulu",
            title = "Shaka: The Rise of the Zulu King",
            origin = "Zulu Legend (South Africa)",
            category = "African History",
            genre = "Action",
            minAge = 10,
            readTime = "15 min read",
            summary = "How a young outcast revolutionized warfare and built a mighty empire.",
            iconEmoji = "⚔️",
            imageUrl = "https://images.unsplash.com/photo-1516026672322-bc52d61a55d5?q=80&w=400",
            content = """
In the rolling hills of KwaZulu, a young boy named Shaka was born. He was an outcast, rejected by his father's clan. But Shaka had a fire in his spirit that could not be extinguished.
[img:https://images.unsplash.com/photo-1516026672322-bc52d61a55d5?q=80&w=400]
He realized that the old ways of fighting—throwing spears from a distance—were ineffective. He forged a new weapon, the *iklwa*, a short stabbing spear designed for close combat. He trained his warriors in the 'Buffalo Horns' formation, surrounding their enemies with terrifying precision.
[img:https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400]
Shaka's army moved like a single organism. They ran barefoot to toughen their feet and marched for miles without rest. Soon, the small Zulu clan became the center of a vast empire, uniting dozens of tribes under one banner.
[img:https://images.unsplash.com/photo-1493246507139-91e8bef99c17?q=80&w=400]
His reign was one of discipline and power, but also of great change. He showed that from the humblest beginnings, one can reshape the world. His legacy lives on in the heartbeat of the Zulu nation.
            """.trimIndent(),
            moralLesson = "Innovation and discipline can turn an outcast into a king.",
            speechRate = 0.85f,
            pitch = 0.9f
        ),

        // --- FABLES (ANIMAL STORIES) ---
        SampleStory(
            id = "hare_and_hyena",
            title = "The Clever Hare & The Greedy Hyena",
            origin = "East African Fable",
            category = "Animal Fables",
            genre = "Fables",
            minAge = 4,
            readTime = "10 min read",
            summary = "Sungura the Hare uses his quick wits to outsmart the greedy Hyena during a drought.",
            iconEmoji = "🐇",
            imageUrl = "https://images.unsplash.com/photo-1591824438708-ce405f36ba3d?q=80&w=400",
            content = """
Once upon a time, during a season of great drought across the savannah, food became scarce for all animals. The rivers dried up, and the grass turned yellow and brittle.
[img:https://images.unsplash.com/photo-1591824438708-ce405f36ba3d?q=80&w=400]
Sungura the Hare, known for his cleverness, found a secret patch of sweet potatoes hidden behind a rocky hill. He ate his fill every day. But the greedy Hyena, who spent his time sleeping instead of searching, noticed Sungura's round belly. "Tell me your secret, Hare!" he demanded.
[img:https://images.unsplash.com/photo-1564349683136-77e08bef1ed1?q=80&w=400]
Sungura, knowing Hyena's greed, decided to teach him a lesson. "I found a way to catch fish in the dry sand!" he lied. "You just have to bury your tail in the sand at night and wait for the 'sand-fish' to bite." Hyena believed him and sat all night in the cold sand, his tail buried deep.
[img:https://images.unsplash.com/photo-1547970810-dc1eef472997?q=80&w=400]
In the morning, Hyena was frozen stiff and had caught nothing but a cold. Sungura laughed and told him, "Hard work and observation find food, not laziness and tricks!" Hyena slinked away, his stomach still rumbling, while Sungura hopped back to his secret garden.
            """.trimIndent(),
            moralLesson = "Hard work and wit are better than greed and laziness.",
            speechRate = 1.1f,
            pitch = 1.2f
        ),
        SampleStory(
            id = "lion_and_jackal",
            title = "The Lion and the Clever Jackal",
            origin = "Southern African Fable",
            category = "Animal Fables",
            genre = "Fables",
            minAge = 5,
            readTime = "12 min read",
            summary = "How a tiny jackal saved himself from the King of the Jungle.",
            iconEmoji = "🦊",
            imageUrl = "https://images.unsplash.com/photo-1534188753412-3ee2f7f9fd8f?q=80&w=400",
            content = """
The Great Lion was hungry, and he had trapped a small Jackal in a narrow cave. "Today, you are my dinner!" the Lion roared, his breath hot against the Jackal's fur.
[img:https://images.unsplash.com/photo-1534188753412-3ee2f7f9fd8f?q=80&w=400]
The Jackal, thinking fast, looked up at the cave ceiling and screamed, "Oh no! The sky is falling! Look, the roof of the cave is about to collapse! Great King, hold up the roof with your mighty paws while I run to get a support beam!"
[img:https://images.unsplash.com/photo-1614027164847-1b2809eb189d?q=80&w=400]
The Lion, terrified of the sky falling, pressed his huge paws against the ceiling. "Hurry, Jackal!" he yelled. The Jackal ran out of the cave and never came back. The Lion stood there for hours, his muscles aching, until he realized the roof wasn't moving at all.
[img:https://images.unsplash.com/photo-1546182208-99c197e52196?q=80&w=400]
By the time the Lion stepped out, the Jackal was miles away, laughing with his friends. The Lion learned that even the strongest king can be fooled by a clever mind.
            """.trimIndent(),
            moralLesson = "Size and strength are no match for a quick mind.",
            speechRate = 1.15f,
            pitch = 1.1f
        ),
        SampleStory(
            id = "tortoise_and_birds",
            title = "The Tortoise and the Feast in the Sky",
            origin = "Igbo Fable (Nigeria)",
            category = "Animal Fables",
            genre = "Fables",
            minAge = 5,
            readTime = "14 min read",
            summary = "Tortoise hitches a ride to a celestial party, but his greed costs him dearly.",
            iconEmoji = "🐢",
            imageUrl = "https://images.unsplash.com/photo-1548550023-2bdb3c5beed7?q=80&w=400",
            content = """
There was a great famine on earth, but the Birds had been invited to a feast in the sky. The Tortoise, always hungry and full of tricks, begged the birds to take him along. "But you have no wings!" they said.
[img:https://images.unsplash.com/photo-1548550023-2bdb3c5beed7?q=80&w=400]
Tortoise persuaded each bird to give him one feather. He stuck them to his shell and flew up with them. Before they arrived, he told them, "We must each take a new name for the party. My name will be 'All of You'."
[img:https://images.unsplash.com/photo-1452570053594-1b985d6ea890?q=80&w=400]
When the food was served, the hosts said, "This is for *all of you*." Tortoise stepped forward and ate everything, saying, "Remember, my name is All of You!" The birds were furious. They took back their feathers and left him stranded in the sky.
[img:https://images.unsplash.com/photo-1510798831971-661eb04b3739?q=80&w=400]
Tortoise had to jump. He crashed onto a pile of hard rocks, shattering his smooth shell. A medicine man glued it back together, which is why the tortoise's shell is jagged and cracked to this very day.
            """.trimIndent(),
            moralLesson = "Greed leads to a fall, and selfishness leaves you without friends.",
            speechRate = 1.0f,
            pitch = 1.0f
        ),
        SampleStory(
            id = "why_zebra_stripes",
            title = "How the Zebra Got His Stripes",
            origin = "San Legend (Namibia)",
            category = "Animal Fables",
            genre = "Fables",
            minAge = 4,
            readTime = "10 min read",
            summary = "A story of a fight between a baboon and a zebra over a water hole.",
            iconEmoji = "🦓",
            imageUrl = "https://images.unsplash.com/photo-1501705388883-4ed8a543392c?q=80&w=400",
            content = """
Long ago, the Zebra was all white. One year, the drought was so bad that only one water hole remained, and it was guarded by a grumpy Baboon who sat by a fire.
[img:https://images.unsplash.com/photo-1501705388883-4ed8a543392c?q=80&w=400]
The Zebra came to drink, but the Baboon refused. "I am the Lord of the Water!" he barked. They began to fight, kicking and biting. The Zebra gave a mighty kick that sent the Baboon flying into the rocks.
[img:https://images.unsplash.com/photo-1540573133985-87b6da6d54a9?q=80&w=400]
But the Zebra also tripped and fell right through the Baboon's fire! The burning logs left black stripes all across his beautiful white coat. He ran away into the savannah, proud of his new look.
[img:https://images.unsplash.com/photo-1526095179574-86e545346ac6?q=80&w=400]
The Baboon landed on his backside on the hot rocks, which is why he has a red patch there today. And the Zebra kept his stripes as a badge of his bravery in the fight for the water.
            """.trimIndent(),
            moralLesson = "Bravery for a good cause is rewarded, even if it leaves a mark.",
            speechRate = 1.05f,
            pitch = 1.15f
        ),

        // --- MYTHS ---
        SampleStory(
            id = "anansi_wisdom",
            title = "Anansi and the Pot of Wisdom",
            origin = "Ashanti / West Africa",
            category = "African Folklore",
            genre = "Myths",
            minAge = 5,
            readTime = "12 min read",
            summary = "Anansi tries to keep all the world's wisdom in a calabash top high in a tree.",
            iconEmoji = "🕷️",
            imageUrl = "https://images.unsplash.com/photo-1523906834658-6e24ef2386f9?q=80&w=400",
            content = """
Long ago, Kwaku Anansi the Spider possessed all the wisdom of the world. He decided to keep it all to himself, packing it into a large calabash. 
[img:https://images.unsplash.com/photo-1523906834658-6e24ef2386f9?q=80&w=400]
He thought, "If I hide this wisdom high in a silk-cotton tree, I will be the smartest being alive!" He tied the calabash to his belly and began to climb. But the calabash was so big he couldn't reach the branches.
[img:https://images.unsplash.com/photo-1473448912268-2022ce9509d8?q=80&w=400]
His son, Ntikuma, watched from below and laughed. "Father, if you tie the pot to your back, you can climb easily!" Anansi was so angry that his son was wiser than him that he dropped the pot. It shattered, and wisdom scattered to every corner of the earth.
[img:https://images.unsplash.com/photo-1509333947089-6799bcd4265f?q=80&w=400]
That is why today, everyone has a little bit of wisdom, but no one has it all. Anansi went home, realizing that trying to hoard knowledge only makes you look foolish.
            """.trimIndent(),
            moralLesson = "No one person can hold all the world's wisdom.",
            speechRate = 1.0f,
            pitch = 1.1f
        ),

        // --- ROMANCE ---
        SampleStory(
            id = "stars_romance",
            title = "When the Moon Met the Sun",
            origin = "Celestial Myth",
            category = "Romantic Legends",
            genre = "Romance",
            minAge = 6,
            readTime = "10 min read",
            summary = "A beautiful tale of how the sun and moon chase each other across the sky.",
            iconEmoji = "☀️",
            imageUrl = "https://images.unsplash.com/photo-1502481851512-e9e2529bbbf9?q=80&w=400",
            content = """
In the beginning of time, the Sun and the Moon were the best of friends. They shared the sky together, dancing through the clouds from dawn until dusk.
[img:https://images.unsplash.com/photo-1502481851512-e9e2529bbbf9?q=80&w=400]
But the Great Spirit saw that the creatures of the earth were confused. "There must be a time for light and a time for rest," the Spirit declared. So the Sun was given the day, and the Moon was given the night.
[img:https://images.unsplash.com/photo-1470252649358-96759a8ef394?q=80&w=400]
They were heartbroken to be separated. The Sun shines his brightest to try and see the Moon, and the Moon reflects the Sun's light to show him she is still there. 
[img:https://images.unsplash.com/photo-1532693322450-2cb5c511067d?q=80&w=400]
Occasionally, the Spirit allows them to touch during an eclipse, a brief and beautiful moment where day and night become one. Their love reminds us that even when we are apart, we are connected by the same sky.
            """.trimIndent(),
            moralLesson = "True friendship and love endure despite distance and time.",
            speechRate = 1.0f,
            pitch = 1.0f
        ),

        // --- THRILLER ---
        SampleStory(
            id = "blossoms_savannah",
            title = "Blossoms of the Savannah: The Rescue",
            origin = "Kenya (Maa Literature)",
            category = "African Literature",
            genre = "Thriller",
            minAge = 12,
            readTime = "15 min read",
            summary = "The story of two sisters, Resian and Taiyo, who fight against ancient traditions.",
            iconEmoji = "🌸",
            imageUrl = "https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400",
            content = """
In the heart of Nasila, two sisters, Resian and Taiyo, found themselves caught in a dangerous web of tradition and betrayal. Their father had promised them to men they did not love.
[img:https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400]
One dark night, Resian realized that the time for their 'initiation' had come. She knew she had to flee. She woke Taiyo, and with nothing but the clothes on their backs, they vanished into the tall grass of the savannah.
[img:https://images.unsplash.com/photo-1516026672322-bc52d61a55d5?q=80&w=400]
They were hunted by the village warriors. Every snap of a twig sounded like a heartbeat. They reached the river, where the currents were fierce. "We must cross, or we lose our future!" Resian cried.
[img:https://images.unsplash.com/photo-1437482078695-73f5ca6c96e2?q=80&w=400]
With courage they had never known, they swam against the tide. They reached the other side, entering a new world where they could finally choose their own paths. The blossoms of the savannah were finally free to bloom.
            """.trimIndent(),
            moralLesson = "Courage is required to stand up for one's rights and future.",
            speechRate = 0.95f,
            pitch = 1.0f
        ),

        // --- HORROR ---
        SampleStory(
            id = "ghost_of_kajiado",
            title = "The Ghost of Kajiado",
            origin = "Modern Kenyan Folklore",
            category = "Ghost Stories",
            genre = "Horror",
            minAge = 14,
            readTime = "10 min read",
            summary = "Late night drivers speak of a figure that appears on the dusty roads near Kajiado.",
            iconEmoji = "👻",
            imageUrl = "https://images.unsplash.com/photo-1509248961158-e54f6934749c?q=80&w=400",
            content = """
The road to Kajiado is long and lonely at night. The dust kicks up in the moonlight, creating shapes that look like dancing spirits.
[img:https://images.unsplash.com/photo-1509248961158-e54f6934749c?q=80&w=400]
A truck driver once stopped for a woman in a white dress standing by the road. She didn't speak, only pointed toward the horizon. As he drove, the air in the cabin became ice-cold.
[img:https://images.unsplash.com/photo-1448375240586-882707db888b?q=80&w=400]
He looked in his rearview mirror and saw her eyes glowing like embers. When he blinked, she was gone, leaving only a scent of wild jasmine and the sound of a distant, mournful whistle.
[img:https://images.unsplash.com/photo-1505635330303-27200774a03f?q=80&w=400]
Locals say she is the guardian of the plains, protecting the land from those who travel with dark hearts. Don't stop for strangers in Kajiado after the clock strikes twelve.
            """.trimIndent(),
            moralLesson = "Respect the mysteries of the night and the spirits of the land.",
            speechRate = 0.75f,
            pitch = 0.6f
        ),
        // --- ADDITIONAL STORIES TO REACH 6 PER CATEGORY ---
        // ACTION (3/6)
        SampleStory(
            id = "queen_amina",
            title = "Queen Amina of Zazzau",
            origin = "Hausa Legend (Nigeria)",
            category = "African History",
            genre = "Action",
            minAge = 10,
            readTime = "15 min read",
            summary = "The warrior queen who expanded her kingdom through conquest and built massive walls.",
            iconEmoji = "🛡️",
            imageUrl = "https://images.unsplash.com/photo-1599727484725-502a5e848698?q=80&w=400",
            content = """
Amina was the daughter of Queen Bakwa Turunku, but she did not want to spend her time in the palace. She preferred the sound of clashing swords and the thunder of horse hooves.
[img:https://images.unsplash.com/photo-1599727484725-502a5e848698?q=80&w=400]
She became the leader of the Zazzau cavalry. Amina was the first to have a standing army of female warriors who fought with the ferocity of lions. She conquered the lands as far as the sea, demanding tribute in the form of kola nuts and gold.
[img:https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400]
To protect her growing empire, she built massive earthen walls around her cities, many of which still stand today as "Amina's Walls." Her courage redefined what a leader could be in the Sahel.
            """.trimIndent(),
            moralLesson = "Leadership and bravery are not defined by gender.",
            speechRate = 0.9f,
            pitch = 1.0f
        ),
        // ADVENTURE (1/6)
        SampleStory(
            id = "sundiata_keita",
            title = "Sundiata: The Lion King of Mali",
            origin = "Mali Legend",
            category = "African Folklore",
            genre = "Adventure",
            minAge = 8,
            readTime = "20 min read",
            summary = "The story of the crippled prince who rose to become the founder of the Mali Empire.",
            iconEmoji = "🦁",
            imageUrl = "https://images.unsplash.com/photo-1546182208-99c197e52196?q=80&w=400",
            content = """
Sundiata was born weak. He could not walk for many years, and he was mocked by the other princes. But his mother, Sogolon, believed in his greatness. 
[img:https://images.unsplash.com/photo-1546182208-99c197e52196?q=80&w=400]
One day, after being insulted, Sundiata used an iron rod to pull himself up. He stood for the first time, and the rod bent into a bow! He then traveled across the kingdoms, gathering allies and learning the secrets of magic and war.
[img:https://images.unsplash.com/photo-1493246507139-91e8bef99c17?q=80&w=400]
He returned to his home and defeated the evil sorcerer-king Soumaoro at the Battle of Kirina. Sundiata became the first Mansa of Mali, bringing peace and prosperity to the land.
            """.trimIndent(),
            moralLesson = "Perseverance can overcome any physical limitation.",
            speechRate = 1.0f,
            pitch = 1.0f
        ),
        // FABLES (5/6)
        SampleStory(
            id = "elephant_rhino",
            title = "Why Elephant and Rhino are Enemies",
            origin = "Bantu Fable",
            category = "Animal Fables",
            genre = "Fables",
            minAge = 4,
            readTime = "12 min read",
            summary = "A misunderstanding over a mirror leads to a lifelong rivalry.",
            iconEmoji = "🐘",
            imageUrl = "https://images.unsplash.com/photo-1557050543-4d5f4e07ef46?q=80&w=400",
            content = """
Elephant and Rhino used to be best friends. They even shared the same skin! But one day, they found a magical mirror in the forest that showed your 'inner beauty.'
[img:https://images.unsplash.com/photo-1557050543-4d5f4e07ef46?q=80&w=400]
Elephant looked in the mirror and saw a majestic mountain. Rhino looked and saw a sharp, unstoppable spear. They began to argue about whose image was better.
[img:https://images.unsplash.com/photo-1512633017083-67231aba710d?q=80&w=400]
They fought until the mirror broke. Now, whenever they see each other, they remember the argument and charge, still trying to prove who is the strongest.
            """.trimIndent(),
            moralLesson = "Vanity and pride can destroy even the closest friendships.",
            speechRate = 1.0f,
            pitch = 0.9f
        ),
        // MYTHS (2/6)
        SampleStory(
            id = "creation_myth",
            title = "The Golden Chain from the Sky",
            origin = "Yoruba Myth (Nigeria)",
            category = "Creation Myths",
            genre = "Myths",
            minAge = 6,
            readTime = "18 min read",
            summary = "How Obatala descended from the heavens to create the world.",
            iconEmoji = "🌍",
            imageUrl = "https://images.unsplash.com/photo-1502481851512-e9e2529bbbf9?q=80&w=400",
            content = """
In the beginning, there was only the sky and the vast ocean below. Obatala, the sky-spirit, wanted to create land. He went to Olodumare, the supreme being, and received a long golden chain, a snail shell of sand, and a five-toed chicken.
[img:https://images.unsplash.com/photo-1502481851512-e9e2529bbbf9?q=80&w=400]
He climbed down the chain for seven days. When he reached the bottom, he poured the sand onto the water. The chicken scratched the sand, spreading it far and wide to create the continents.
[img:https://images.unsplash.com/photo-1518709268805-4e9042af9f23?q=80&w=400]
Obatala planted a palm nut, and soon trees and mountains grew. He then shaped the first humans out of clay. Olodumare breathed life into them, and the world began to pulse with the rhythm of life.
            """.trimIndent(),
            moralLesson = "Every great creation starts with a small step and a bit of faith.",
            speechRate = 0.9f,
            pitch = 1.0f
        ),
        // ROMANCE (2/6)
        SampleStory(
            id = "queen_sheba",
            title = "The Love of Solomon and Sheba",
            origin = "Ethiopian Legend",
            category = "Romantic Legends",
            genre = "Romance",
            minAge = 10,
            readTime = "15 min read",
            summary = "The legendary meeting of two great rulers and the bond they formed.",
            iconEmoji = "👑",
            imageUrl = "https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400",
            content = """
Makeda, the Queen of Sheba, traveled from Ethiopia to Jerusalem to test the wisdom of King Solomon. She brought camels laden with spices, gold, and precious stones.
[img:https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400]
They spent days discussing the mysteries of the universe and the laws of the heart. Solomon was captivated by her intellect, and Makeda was moved by his kindness.
[img:https://images.unsplash.com/photo-1490730141103-6cac27aaab94?q=80&w=400]
Though they were rulers of different lands, their spirits were united. Their legacy resulted in the birth of a dynasty that would rule Ethiopia for thousands of years, a testament to a love built on mutual respect and wisdom.
            """.trimIndent(),
            moralLesson = "Intellectual connection is the foundation of lasting love.",
            speechRate = 1.0f,
            pitch = 1.0f
        ),
        // --- FINAL BATCH TO ENSURE DIVERSITY ---
        SampleStory(
            id = "monkey_crocodile",
            title = "The Monkey and the Crocodile",
            origin = "East African Fable",
            category = "Animal Fables",
            genre = "Fables",
            minAge = 4,
            readTime = "12 min read",
            summary = "A story of a betrayal and a quick escape in the river.",
            iconEmoji = "🐒",
            imageUrl = "https://images.unsplash.com/photo-1540573133985-87b6da6d54a9?q=80&w=400",
            content = """
A Monkey lived on a tree full of sweet jambul fruit by the river. He became friends with a Crocodile and gave him fruit every day. One day, the Crocodile's wife said, "If he eats such sweet fruit, his heart must be even sweeter! Bring it to me."
[img:https://images.unsplash.com/photo-1540573133985-87b6da6d54a9?q=80&w=400]
The Crocodile invited the Monkey for dinner and carried him on his back. In the middle of the river, he told the truth. The Monkey, terrified but calm, said, "Oh friend! I left my heart on the tree. Let's go back and get it."
[img:https://images.unsplash.com/photo-1518063319789-7217e6706b04?q=80&w=400]
As soon as they reached the shore, the Monkey scrambled up the tree. "Go away, false friend!" he shouted. "My heart is safe, and our friendship is over."
            """.trimIndent(),
            moralLesson = "Stay calm in danger and beware of false friends.",
            speechRate = 1.1f,
            pitch = 1.2f
        ),
        SampleStory(
            id = "princess_mnyazi",
            title = "Mnyazi: The Giriama Warrior Princess",
            origin = "Mekatilili wa Menza (Kenya)",
            category = "African History",
            genre = "Action",
            minAge = 10,
            readTime = "18 min read",
            summary = "The woman who led the Giriama people against colonial rule.",
            iconEmoji = "👊",
            imageUrl = "https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400",
            content = """
Mnyazi, later known as Mekatilili, was a widow who saw her people suffering under foreign rule. She traveled from village to village, performing the 'kifudu' dance to gather the people and inspire them to resist.
[img:https://images.unsplash.com/photo-1523800503107-5bc3ba2a6f81?q=80&w=400]
She slapped a colonial administrator in public, a symbol of defiance that sparked a great uprising. Even when she was captured and exiled hundreds of miles away, she escaped and walked all the way back home to continue the fight.
[img:https://images.unsplash.com/photo-1493246507139-91e8bef99c17?q=80&w=400]
Her spirit was like a wild fire that could not be put out. She showed that one person's voice can wake up an entire nation.
            """.trimIndent(),
            moralLesson = "Freedom is worth every sacrifice.",
            speechRate = 0.9f,
            pitch = 0.8f
        ),
        SampleStory(
            id = "rainbow_serpent",
            title = "The Rainbow Serpent and the Rain",
            origin = "General African Myth",
            category = "Nature Myths",
            genre = "Myths",
            minAge = 5,
            readTime = "15 min read",
            summary = "How a great serpent brought the first rain to the dry earth.",
            iconEmoji = "🌈",
            imageUrl = "https://images.unsplash.com/photo-1532693322450-2cb5c511067d?q=80&w=400",
            content = """
The earth was parched, and the animals were crying out for water. A giant serpent with scales of every color rose from the deep underground.
[img:https://images.unsplash.com/photo-1532693322450-2cb5c511067d?q=80&w=400]
As the serpent arched its body across the sky, it touched the clouds, and they began to weep with joy. This was the first rain. Wherever the serpent touched the ground, rivers and lakes were born.
[img:https://images.unsplash.com/photo-1470252649358-96759a8ef394?q=80&w=400]
To this day, we see the serpent's scales in the sky after a storm, a reminder of the gift of water that keeps all things alive.
            """.trimIndent(),
            moralLesson = "Nature provides what we need when we respect its power.",
            speechRate = 1.0f,
            pitch = 1.0f
        ),
        SampleStory(
            id = "hidden_gold_city",
            title = "The Hidden City of Gold",
            origin = "Timbuktu Legend",
            category = "Adventure",
            genre = "Adventure",
            minAge = 8,
            readTime = "20 min read",
            summary = "A young traveler searches for the fabled library in the desert.",
            iconEmoji = "🏜️",
            imageUrl = "https://images.unsplash.com/photo-1509333947089-6799bcd4265f?q=80&w=400",
            content = """
Omar was a young boy who loved books more than anything. He heard of a city in the desert where the buildings were made of gold and the libraries held every secret of the stars.
[img:https://images.unsplash.com/photo-1509333947089-6799bcd4265f?q=80&w=400]
He joined a caravan and crossed the shifting sands of the Sahara. He faced sandstorms that turned day into night and followed the ancient paths guided by the North Star.
[img:https://images.unsplash.com/photo-1512351737369-0d131f15197d?q=80&w=400]
When he finally reached Timbuktu, he found that the 'gold' was actually the priceless manuscripts and the wisdom of the scholars. He realized that true wealth is not in metal, but in knowledge.
            """.trimIndent(),
            moralLesson = "Knowledge is the greatest treasure one can find.",
            speechRate = 1.0f,
            pitch = 1.1f
        )
    )

    val stories = mutableStateListOf<SampleStory>().apply {
        addAll(initialStories)
    }

    fun addStory(newStory: SampleStory) {
        stories.add(0, newStory)
    }

    // Remove user created story by ID
    fun deleteStory(storyId: String) {
        stories.removeAll { it.id == storyId }
    }
}