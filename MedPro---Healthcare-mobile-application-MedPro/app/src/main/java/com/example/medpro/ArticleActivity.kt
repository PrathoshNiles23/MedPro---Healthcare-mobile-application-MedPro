package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import com.example.medpro.databinding.ActivityMainBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var mySearchView: SearchView
    lateinit var myList: ListView
    lateinit var list: ArrayList<String>
    lateinit var home:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

            mySearchView = findViewById(R.id.sv)
            myList = findViewById(R.id.myList)
        home = findViewById(R.id.btnHome)

        home.setOnClickListener{
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


            var list: ArrayList<String> = ArrayList()


            list.add("Tips for Making Sure Your Nutritional Needs Are Met Each Day - " + "\n" +
                    "Eating healthy is an important part of living a healthy lifestyle. But, with so many different opinions on what it means to eat healthy, it can be difficult to know where to start when it comes to making sure your nutritional needs are met each day. Fortunately, there are some simple tips that can help you make sure you get all the nutrients your body needs.\n" +
                    "\n" +
                    "Start With the Basics\n" +
                    "When creating a meal plan for yourself, it is important to make sure you include a balance of protein, carbohydrates, and fats. Protein helps build and repair muscle tissue and provides essential amino acids, carbohydrates provide energy, and fat helps keep cell walls strong and provides essential fatty acids. A general rule of thumb is that proteins should make up about 20-30% of your caloric intake, carbohydrates should be 40-60%, and fats should be 20-35%.\n" +
                    "\n" +
                    "Incorporate Variety\n" +
                    "In addition to focusing on the basics, it is also important to incorporate variety into your diet. Eating a variety of foods ensures that you’re getting all the vitamins and minerals needed for optimal health. Try adding fresh fruits and vegetables into your meals every day as well as whole grains such as quinoa or brown rice instead of processed white rice or breads. Incorporating lean meats like chicken or fish in your meals will also help provide additional protein while keeping fats in check.\n" +
                    "\n" +
                    "Pay Attention to Portion Sizes\n" +
                    "It’s just as important to pay attention to portion sizes as it is the types of food you’re consuming. Eating too much can lead to weight gain, so be mindful of how much you put onto your plate at each meal. It’s best practice to fill half your plate with fruits and veggies, then divide the other half between lean proteins and complex carbs like grains or legumes. This will help keep calories in check while ensuring that you get all the vitamins, minerals, and other nutrients needed for good health each day.\n" +
                    "\n" +
                    "Use Supplements\n" +
                    "\n" +
                    "\n" +
                    "Supplements can be a great way to fill any gaps in your diet, but they should not be seen as a replacement for real food. Instead, use them to supplement what you’re already eating. For example, if you’re not getting enough calcium or vitamin D from your regular meals and snacks, adding a daily supplement from a company like LIVS Gummies can help ensure that you get the nutrients needed for bones and teeth health.\n" +
                    "\n" +
                    "Making sure your nutritional needs are met each day doesn’t have to be complicated or expensive. By following these simple tips—focusing on a balance of protein, carbs, fats, incorporating variety, and paying attention to portion sizes—you can easily create meals that meet all your nutritional needs without having to rely on any special diets or supplements. With some planning ahead, eating healthy can become an easy part of anyone’s daily routine. However, if you do feel that you need additional nutrients or vitamins, then supplements can be a great option as well. Speak to your doctor or nutritionist to determine which supplements might be right for you and how they should best be incorporated into your daily routine")
            list.add("The Importance of Self-Care: A Guide to Maintaining Wellness and Managing Weight-" + "\n" + "Self-care refers to activities individuals can do to maintain and improve their physical, emotional, and mental health. These activities often bring joy or relaxation, essential in allowing us to feel our best. Taking time for self-care can include making time for hobbies, journaling, exercising, eating right, and getting enough sleep. Doing these things proactively gives us the energy and motivation to achieve our daily goals and take care of our responsibilities easily. The most important thing is to identify what works best for you as an individual to stay healthy and balanced mentally and physically. Investing in ourselves regularly helps enhance all areas of life, from relationships to work performance. Ultimately, making a dedicated effort toward self-care will set a strong foundation for overall wellness.")
            list.add("Common Health Conditions Caused By Hormonal Imbalances -"+ "\n" +"Hormonal imbalances can cause a variety of health problems, including fatigue, weight gain, and mood swings.\n" +
                    "If you often find yourself feeling fatigued, gaining weight, or experiencing mood swings, it could be a sign of a hormonal imbalance. Hormonal imbalances can cause a wide range of health problems, from headaches and digestive issues to depression and fertility issues. While the effects of hormones can be very serious, they are also highly treatable. Seeking advice from your doctor is key to getting back on track and achieving good physical and mental health. With appropriate medical interventions, people struggling with hormone disruption can be well on their way to feeling their best again.")
            list.add("Winning Ways to Strengthen Faith in Yourself - The core of all faith stems from the deeply rooted conviction and heartfelt expectation of better things to come. Fueled by our belief in someone, something, or a higher power such as God, faith is the pathway to realizing our true potential.  It promotes from within us a “can do” attitude and diminishes the stress, anxiety, and fear that might otherwise paralyze our ability to act. Without it, we are likely to drown in our own sense of hopelessness, especially during times of adversity.\n" +
                    "\n" +
                    "The core of all faith stems from the deeply rooted conviction and heartfelt expectation of better things to come. Fueled by our belief in someone, something, or a higher power such as God, faith is the pathway to realizing our true potential.  It promotes from within us a “can do” attitude and diminishes the stress, anxiety, and fear that might otherwise paralyze our ability to act. Without it, we are likely to drown in our own sense of hopelessness, especially during times of adversity.\n" +
                    "\n" +
                    "As a rule, we are capable of accomplishing far more than we could ever imagine possible. Faith is incomplete until we can tap into what it means to have faith in ourselves. To believe in ourselves gives us that extra leverage of confidence and purpose to achieve what we might have considered beyond our scope.\n" +
                    "\n" +
                    "Have no illusion that faith is the end all to every hurdle you will encounter because it is not.  However, it is a necessity on your journey to a more fulfilling life.\n" +
                    "\n" +
                    "Winning Ways to Strengthen Faith in Yourself\n" +
                    "To strengthen faith in yourself, be resolved to work through the following important steps:\n" +
                    "\n" +
                    "Step #1:  Create a “winning” mindset by imagining the endless possibilities that surround you.\n" +
                    "\n" +
                    "Step #2:  Accept your current situation as where you are now but not where you are meant to stay.\n" +
                    "\n" +
                    "Step #3:  Assess your strengths and limitations as they relate to your daily regiment and define what tactics you need to implement to make improvements.\n" +
                    "\n" +
                    "Step #4:  Use your past successes and failings as learning points and opportunities for personal growth.\n" +
                    "\n" +
                    "Step #5:  Draw from the courage, strength, and determination that rests within you to be your personal source of power.\n" +
                    "\n" +
                    "Step #6:  Treat your challenges as opportunities to be conquered.\n" +
                    "\n" +
                    "Step #7:  No matter how bleak things may seem, look for the solution with a positive perspective.\n" +
                    "\n" +
                    "Step #8:  Forgive yourself for the past failings and mistakes you have made and use them as an inspiration to do better in the future.\n" +
                    "\n" +
                    "Step #9:  Establish and implement meaningful goals that will open new doors for you both personally and professionally.  Do the legwork to develop your competencies in the areas required to realize your goals.\n" +
                    "\n" +
                    "Step #10: Faith without a shred of evidence to suggest the outcome will lead you down a blind alley. Believe in what you intuitively know to be reasonable and right based upon some level of reliable information.\n" +
                    "\n" +
                    "Step #11: Chronically doubting yourself is a mindset that cannot be easily changed.  Have patience and compassion as you work through the process of strengthening your belief in self.\n" +
                    "\n" +
                    "Step #12: No matter what might be, have faith in yourself to become the extraordinary person you were always slated to be.\n" +
                    "\n" +
                    "Have faith you can…and you will!")
            list.add("Practical Tips to Achieve a Positive Mindset -" + "\n" + "The “power of positive thinking” is a popular concept, and sometimes it can feel a little cliché. But the physical and mental benefits of positive thinking have been demonstrated by multiple scientific studies. Positive thinking can give you more confidence, improve your mood, and even reduce to likelihood of developing conditions such as hypertension, depression, and other stress-related disorders.\n" +
                    "\n" +
                    "All this sounds great, but what does the “power of positive thinking” really mean?\n" +
                    "You can define positive thinking as positive imagery, positive self-talk or general optimism, but these are all still general, ambiguous concepts. If you want to be effective in thing and being more positive, you’ll need concrete examples to help you through the process.\n" +
                    "\n" +
                    "Start the day with positive affirmation.\n" +
                    "How you start the morning sets the tone for the rest of the day. Instead of letting negative thoughts dominate you, start your day by telling yourself with statements like, “Today will be a good day” or “I’m going to be awesome today.” You’ll be amazed how much your day improves.\n" +
                    "\n" +
                    "Focus on the good things, however small.\n" +
                    "\n" +
                    "\n" +
                    "Almost invariably, you’re going to encounter obstacles throughout the day – there’s no such perfect day. When you encounter such a challenge, focus on the benefits, not matter how slight or unimportant they seem. For example, if you get stuck in traffic, think about how you now have time to listen to your favorite radio station.\n" +
                    "\n" +
                    "Find humor in bad situations.\n" +
                    "Allow yourself to experience humor in even the darkest or most trying situations. Remind yourself that this situation will probably make for a good story later and try to crack a joke about it.\n" +
                    "\n" +
                    "Turn failures into lessons.\n" +
                    "You aren’t perfect. You’re going to make mistakes and experience failure in multiple contexts, at multiple jobs and with multiple people. Instead of focusing on how you failed, thing about what you’re going to do next time – turn your failure into a lesson.\n" +
                    "\n" +
                    "Transform negative self-talk into positive self-talk.\n" +
                    "Negative self-talk can creep up easily and is often hard to notice. You might think “I’m so bad at this” or “I shouldn’t have tried that.” When you catch yourself doing this, step and replace those negative messages with positive ones.\n" +
                    "\n" +
                    "Focus on the present.\n" +
                    "Most sources of negativity stem from a memory of a recent event or the exaggerated imagination of a potential event. Stay in the present moment.\n" +
                    "\n" +
                    "Find positive friends, mentors, and co-workers.\n" +
                    "When you surround yourself with positive people, you’ll hear positive outlooks, positive stories, and positive affirmations. Do what you can to improve the positivity of others, and let their positivity affect you the same way")

            val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

            myList.adapter = adapter


            mySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    mySearchView.clearFocus()
                    if(list.contains(query)){
                        adapter.filter.filter(query)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    adapter.filter.filter(newText)

                    return true

                }

            })



    }
}