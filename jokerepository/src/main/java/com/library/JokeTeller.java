package com.library;

import java.util.Random;

public class JokeTeller {
    private static  final String jokes[]= new String[]{
            "Girl: You would be a good dancer except for two things. \nBoy: What are the two things? \nGirl: Your feet. ",
            "A family of mice were surprised by a big cat. Father Mouse jumped and and said, \"Bow-wow!\" The cat ran away. \"What was that, Father?\" asked Baby Mouse. \"Well, son, that's why it's important to learn a second language.\"",
            "My friend said he knew a man with a wooden leg named Smith. \nSo I asked him \"What was the name of his other leg?\"",
            "The doctor to the patient: 'You are very sick' \nThe patient to the doctor: 'Can I get a second opinion?' \nThe doctor again: 'Yes, you are very ugly too...'",
            "Patient: Doctor, I have a pain in my eye whenever I drink tea. \nDoctor: Take the spoon out of the mug before you drink. ",
            "A snail walks into a bar and the barman tells him there's a strict policy about having snails in the bar and so kicks him out. A year later the same snail re-enters the bar and asks the barman \"What did you do that for?\"",
            "Mother: \"Did you enjoy your first day at school?\" \nGirl: \"First day? Do you mean I have to go back tomorrow? "
    };

    public static String getRandomJoke(){
        int i = new Random().nextInt(jokes.length);
        return jokes[i];
    }
    public static String[] getAllJokes(){
        return jokes;
    }
}
