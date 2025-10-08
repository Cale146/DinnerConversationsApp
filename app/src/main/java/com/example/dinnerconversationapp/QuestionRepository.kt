package com.example.dinnerconversationapp

/**
 * Central repository of all conversation questions organised by category.
 * Additional questions can be added here without affecting the UI logic.
 */
object QuestionRepository {
    /**
     * Light-hearted prompts designed for children and family dinner conversations.
     */
    val kidsQuestions: List<String> = listOf(
        // --- Original ---
        "If you could have any superpower, what would it be?",
        "What is your favorite thing to do on the weekend?",
        "If you could be any animal, which one would you be?",
        "What makes you laugh the most?",
        "If you could travel anywhere in the world, where would you go?",
        "What is your favorite book or story?",
        "If you had a time machine, would you go to the past or the future?",
        "What's your favorite subject in school and why?",
        "If you could invent something, what would it be?",
        "What is your favorite food that we eat at dinner?",
        "If you could meet a famous person, who would it be?",
        "What is something new you learned recently?",
        "If you could have a pet dragon or a pet unicorn, which would you choose?",
        "What is your favorite family tradition?",
        "If you could spend a day as a character in a movie or book, who would you be?",
        // --- New Additions ---
        "If your pet could suddenly talk, what would it say first?",
        "What’s something you built or made that you’re most proud of?",
        "If your favorite toy came alive, what would you do together first?",
        "Would you rather fly like a bird or swim like a dolphin?",
        "If you could rename the days of the week, what would you call them?",
        "What’s one rule you’d make if you were in charge for a day?",
        "What makes someone a good friend?",
        "What’s a sound that always makes you laugh?",
        "If your backpack could tell stories, what would it say about today?",
        "Which would you rather have: an invisible cloak or a teleportation button?",
        "If you could combine two animals, which would they be and what would you name it?",
        "What’s your dream treehouse like inside?",
        "If you were a superhero, what would your name and power be?",
        "What’s your favorite smell in the world?",
        "What’s one thing that makes your family special?",
        "If the sky could rain anything besides water, what would you want it to rain?",
        "What’s the funniest dream you’ve ever had?",
        "If you could make a new holiday, what would people do to celebrate it?",
        "What’s something nice you did for someone this week?"
    )

    /**
     * Intimate and meaningful questions to spark conversation on romantic dates.
     */
    val romanticQuestions: List<String> = listOf(
        // --- Original ---
        "What is your idea of a perfect date night?",
        "When did you first know you loved me?",
        "What do you admire most about our relationship?",
        "What is one of your favorite memories of us together?",
        "If we could take a vacation anywhere together, where would you choose?",
        "What qualities do you value most in a partner?",
        "What song reminds you of me and why?",
        "How do you like to be shown love?",
        "What is something new you would like to try together?",
        "What is one small thing I do that makes you feel appreciated?",
        "How has our relationship changed you?",
        "What were your first impressions of me?",
        "What is something we haven't talked about that you'd like to share?",
        "What does a happy relationship look like to you?",
        "What are your hopes for our future together?",
        // --- New Additions ---
        "When did you first realize you were truly comfortable with me?",
        "What’s a small, ordinary moment with me that still feels magical?",
        "If our relationship were a movie, what scene would be your favorite?",
        "What’s something I do that you secretly love but have never mentioned?",
        "How do you show love when words don’t feel enough?",
        "What does “home” mean to you when you think of us?",
        "Which of our memories always makes you smile instantly?",
        "What’s one dream you’ve had for years that you’d love for us to chase together?",
        "If you could relive one day with me exactly as it happened, which would it be?",
        "How has our relationship changed the way you see yourself?",
        "What’s one way we can make ordinary days feel more special?",
        "What kind of future moments do you secretly imagine with me?",
        "If love had a color, what would ours be today?",
        "What do you think makes our connection different from others?",
        "When was a time you felt especially proud of us as a couple?",
        "What’s something you hope we’re still doing 20 years from now?",
        "Which small gestures make you feel the most cared for?",
        "What have you learned from me without me ever teaching it directly?",
        "What’s a song lyric that reminds you of us?",
        "If we wrote a book together, what would its title be?"
    )

    /**
     * Engaging questions for larger dinner parties and social gatherings.
     */
    val partyQuestions: List<String> = listOf(
        // --- Original ---
        "If you could invite any famous person to dinner, who would it be?",
        "What’s one thing on your bucket list?",
        "What’s the last great movie you watched?",
        "If you could instantly become an expert in anything, what would it be?",
        "What’s your favorite way to spend a day off?",
        "If you could have dinner with any historical figure, who would it be and why?",
        "What’s the most interesting place you’ve ever traveled?",
        "What is your guilty pleasure song?",
        "If you could time travel, which era would you visit?",
        "What is one skill you wish you had?",
        "What’s your favorite thing to cook or bake?",
        "If you were stranded on a desert island, what three items would you want with you?",
        "What was the best concert you've ever attended?",
        "If you won the lottery, what’s the first thing you would do?",
        "What is a hobby you’ve always wanted to pick up?",
        // --- New Additions ---
        "What’s a skill you have that would impress everyone here?",
        "What’s the funniest misunderstanding you’ve ever had?",
        "If you could teleport everyone here somewhere for one night, where would we go?",
        "What’s your most ridiculous fear or superstition?",
        "Which fictional character would you most want at this party?",
        "What’s the strangest food combination you actually enjoy?",
        "What song must play before the night ends?",
        "Who here would survive best in a zombie apocalypse, and why?",
        "What’s your go-to get out of awkward conversation move?",
        "If you had to wear one outfit for a year, what would it be?",
        "What’s your best it seemed like a good idea at the time story?",
        "Which celebrity would you most want to trade places with for 24 hours?",
        "What’s your ultimate feel good movie?",
        "What’s a smell that instantly reminds you of childhood?",
        "Who here would be the best game show host?",
        "What’s a talent you have that no one expects?",
        "What’s your most used emoji and what does it secretly mean for you?",
        "If we all had to form a band, what would it be called?",
        "What’s the most spontaneous thing you’ve ever done?",
        "What’s something you’ve done that you’ll never do again—but don’t regret?",
        "If you could instantly master one hobby or sport, which would you pick?",
        "What’s the funniest thing that’s ever happened at a party you’ve been to?",
        "Who in this room is most likely to get lost on vacation?",
        "What’s your favorite weird internet rabbit hole you’ve ever gone down?",
        "What’s your guilty-pleasure song you’d secretly love to sing right now?"
    )

    /**
     * Returns the list of questions for the given category.
     */
    fun getQuestions(category: QuestionCategory): List<String> = when (category) {
        QuestionCategory.KIDS -> kidsQuestions
        QuestionCategory.ROMANTIC -> romanticQuestions
        QuestionCategory.PARTY -> partyQuestions
    }
}
