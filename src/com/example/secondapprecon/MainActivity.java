package com.example.secondapprecon;

import java.util.Random;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	public Spinner topics_spinner;
	public String selectedTopic;
	public String selectedTopicTitle;
	public String randomPhrase;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//    Spinner Part 1) Populates spinner drowdown list with topics_array   
        topics_spinner = (Spinner) findViewById(R.id.topics_spinner);    
        // Create an ArrayAdapter using the topics string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.topics_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        topics_spinner.setAdapter(adapter);
        
        
//	  Spinner Part 2) Listener is set to take in selected string ("selectedTopic")
    
            
    topics_spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
    
    	  
          public void onItemSelected(AdapterView<?> arg0, View arg1,
                  int arg2, long arg3) {
//          	Spinner topics_spinner1 = (Spinner)findViewById(R.id.topics_spinner);
			selectedTopic = topics_spinner.getSelectedItem().toString(); 
              //if above code needed adjust from topics_spinner --> topics_spinner1
          }
    
          public void onNothingSelected(AdapterView<?> arg0) {
              // TODO Auto-generated method stub

          }
      });

    	 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
 }

//Step 1- Reads Topic Selection and matches to proper array
  
// Take in String 
    public void onClickGetPhrase(View view){
 
    	Resources res = getResources();
    	selectedTopicTitle=selectedTopic;
    	String [] randomizerStringArray={"hello","world"};

    // cut out spaces from string
  		selectedTopicTitle= selectedTopic.replace(" ",""); // minus spaces 
  
  	// match string to R.java array id, lots of if then statements
  		if(selectedTopicTitle.equals("Drinkingwithpeopleyouknow")){
    		randomizerStringArray = res.getStringArray(R.array.Drinkingwithpeopleyouknow);
    		
    	}
  			else if(selectedTopicTitle.equals("Drinkingwithpeopleyoudonotknow")){
    		randomizerStringArray = res.getStringArray(R.array.Drinkingwithpeopleyoudonotknow);
    		
    	}
  			else if(selectedTopicTitle.equals("Talkingwithboringcoworkers")){
    		randomizerStringArray = res.getStringArray(R.array.Talkingwithboringcoworkers);
    		
    	}
  			else if(selectedTopicTitle.equals("Hittingongirls")){
    		randomizerStringArray = res.getStringArray(R.array.Hittingongirls);
    		
    	}
  			else if(selectedTopicTitle.equals("Hittingonguys")){
    		randomizerStringArray = res.getStringArray(R.array.Hittingonguys);
    		
    	}
  			else if(selectedTopicTitle.equals("Drinkingwithpeopleyouknow")){
    		randomizerStringArray = res.getStringArray(R.array.Drinkingwithpeopleyouknow);
    		
    	}
  			else if(selectedTopicTitle.equals("Gettingoutofawkwardsituations")){
    		randomizerStringArray = res.getStringArray(R.array.Gettingoutofawkwardsituations);
    		
    	}
  			else if(selectedTopicTitle.equals("Talkingwithhomelesspeople")){
    		randomizerStringArray = res.getStringArray(R.array.Talkingwithhomelesspeople);
    		
    	}
  			else if(selectedTopicTitle.equals("Talkingwithyourprofessor")){
    		randomizerStringArray = res.getStringArray(R.array.Talkingwithyourprofessor);
    	}
    		else {
    			Toast.makeText(getBaseContext(), "dicks", Toast.LENGTH_SHORT).show();
    		
    	}	
  	// step 2) randomizes and puts out proper phrase
    	randomPhrase = randomizerStringArray[new Random().nextInt(randomizerStringArray.length)];
    	Toast.makeText(getBaseContext(), randomPhrase, Toast.LENGTH_LONG).show();
}

    
// TAKE IN USER INPUT
    
// 1) "Phrase Suggestions?"  Button that will slid to the user input page
    
// 2) Open dialog box for users to put in phrase
    
// 3) Take in phrase and upload to a database/site  
    
    
    
    
    
    
    
}    

//public void onClickGetPhrase(View view) {
//	Resources res = getResources();
//	TypedArray ta = res.obtainTypedArray(R.array.categories0);
//	int n = ta.length();
//	Random rand=new Random();
//	int randomtopicn =rand.nextInt(n);
//	int id = ta.getResourceId(randomtopicn, 0);
//	   if (id > 0) {
//	       String[] strings = res.getStringArray(id);
//	       int m = strings.length;
//	       int randomphrasen= rand.nextInt(m);
//	       String phrase= strings[randomphrasen];
//	       Toast.makeText(getBaseContext(), phrase , Toast.LENGTH_LONG).show();
//	   } 
//	   else {
//	       Toast.makeText(getBaseContext(),"Index out of range", Toast.LENGTH_LONG).show();
//	   }
//	   
//	ta.recycle(); // Important!	
//
//}

