package com.example.russpr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity7 extends AppCompatActivity {


    private Activity mActivity;
    private Button btnNext;
    private TextView tvQuestionText;
    private TextView tvQuestionTitle;
    private RecyclerView mRecyclerQuiz;
    private Context mContext;
    private String mCategoryId, mGivenAnsText, mCorrectAnsText, mQuestionText;
    private boolean mUserHasPressed = false;

    private int mQuestionPosition = 0;


    private QuizAdapter mAdapter = null;
    private List<QuizModel> mItemList;
    ArrayList<String>mOptionList;
    ArrayList<String>mBackgroundColorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        initVar();
        initView();
        initListener();


    }

    private void initVar(){
        mActivity = MainActivity7.this;
        mContext = mActivity.getApplicationContext();

        Intent intent = getIntent();
        if (intent != null){
            mCategoryId = intent.getStringExtra(AppConstants.BUNDLE_KEY_INDEX);
        }
        mItemList = new ArrayList<QuizModel>();
        mOptionList = new ArrayList<>();
        mBackgroundColorList = new ArrayList<>();
    }

    private void initView(){
        btnNext = (Button)findViewById(R.id.btnNext);
        tvQuestionText = (TextView)findViewById(R.id.tvQuestionText);
        tvQuestionTitle =(TextView)findViewById(R.id.tvQuestionTitle);
        mRecyclerQuiz = (RecyclerView)findViewById(R.id.rvQuiz);
        mRecyclerQuiz.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
    public void initListener(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    setNextQuestion();
                }
            }
        });
        mAdapter.setItemClickListener(new ListItemClickListener(){
            @Override
            void onItemClick(int position, View view){
                if (!mUserHasPressed){
                    int clickedAnswerIndex = position;
                    if (mItemList.get(mQuestionPosition).getCorrectAnswer() != -1){
                        for (int currentItemIndex = 0; currentItemIndex < mOptionList.size(); currentItemIndex++){
                            if (currentItemIndex == clickedAnswerIndex && currentItemIndex == mItemList.get(mQuestionPosition).getCorrectAnswer()){
                                mBackgroundColorList.set(currentItemIndex, AppConstants.COLOR_GREEN);
                            }else  if (currentItemIndex == clickedAnswerIndex && ! (currentItemIndex == mItemList.get(mQuestionPosition).getCorrectAnswer())){
                                mBackgroundColorList.set(currentItemIndex, AppConstants.COLOR_RED);
                            }
                        }
                    }
                    mGivenAnsText = mItemList.get(mQuestionPosition).getAnswers().get(clickedAnswerIndex);
                    mCorrectAnsText = mItemList.get(mQuestionPosition).getAnswers().get(mItemList.get(mQuestionPosition).getCorrectAnswer());

                    mUserHasPressed = true;
                }
            }
        });
    }

    public void setNextQuestion() {
        mUserHasPressed = false;
        if (mQuestionPosition < mItemList.size() - 1){
            mQuestionPosition++;
            updateQuestionAndAnswers();
        }
    }

    @SuppressLint("StringFormatInvalid")
    public void updateQuestionAndAnswers(){
        mOptionList.clear();
        mBackgroundColorList.clear();
        ((LinearLayoutManager)mRecyclerQuiz.getLayoutManager()).scrollToPosition(AppConstants.BUNDLE_KEY_ZERO_INDEX);

        mOptionList.addAll(mItemList.get(mQuestionPosition).getAnswers());
        mBackgroundColorList.addAll(mItemList.get(mQuestionPosition).getBackGroundColors());

        mQuestionText = mItemList.get(mQuestionPosition).getQuestion();

        tvQuestionText.setText(Html.fromHtml(mQuestionText));
        tvQuestionTitle.setText(getString(R.string.qiuz_question_text, mQuestionPosition + 1));
    }

    private void loadJson(){
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open(AppConstants.QUESTION_FILE)));
            String temp;
            while ((temp = bufferedReader.readLine()) != null)
                stringBuffer.append(temp);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        parseJson(stringBuffer.toString());
    }

    public void parseJson(String jsonData){
        try {
            JSONObject jsonObjMain = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObjMain.getJSONArray(AppConstants.JSON_KEY_QUESTIONNAIRY);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                String question = jsonObj.getString(AppConstants.JSON_KEY_QUESTION);
                int correctAnswer = Integer.parseInt(jsonObj.getString(AppConstants.JSON_KEY_CORRECT_ANS));
                String catagoryId = jsonObj.getString(AppConstants.JSON_KEY_CATEGORY_ID);

                Log.d("TAG", catagoryId.toString());

                JSONArray jsonArray1 = jsonObj.getJSONArray(AppConstants.JSON_KEY_ANSWERS);
                ArrayList<String> contents = new ArrayList<>();
                ArrayList<String> backgroundColors = new ArrayList<>();
                for (int j = 0; j < jsonArray1.length(); j++){
                    String item_title = jsonArray1.get(j).toString();
                    contents.add(item_title);
                    backgroundColors.add(AppConstants.COLOR_WHITE);
                }
                if (mCategoryId.equals(catagoryId)) {
                    mItemList.add(new QuizModel(question, contents, correctAnswer, catagoryId, backgroundColors));
                }
            }

        }catch (JSONException e){
            e.printStackTrace();
            showEmptyView();
        }
    }

    private void showEmptyView() {
    }

    private class AppConstants {

        public static final  String COLOR_WHITE = "rectangle_white_normal";
        public static final String COLOR_GREEN = "rectangle_quiz_green_normal";
        public static final String COLOR_RED = "rectangle_quiz_red_normal";

        public static final String JSON_KEY_QUESTIONNAIRY = "questionnairies";
        public static final String JSON_KEY_QUESTION = "question";
        public static final String JSON_KEY_ANSWERS = "answers";
        public static final String JSON_KEY_CORRECT_ANS = "correct_answer";
        public static final String JSON_KEY_CATEGORY_ID = "question_category";

        public static final String QUESTION_FILE = "json/quiz/question_set.json";
        public static final String CONTENT_FILE = "json/categories/quiz_category.json";

        public static final int BUNDLE_KEY_ZERO_INDEX = 0;
        public static final String BUNDLE_KEY_INDEX = "index";
    }

    public static class QuizAdapter implements com.example.russpr.QuizAdapter {

        private Context mContext;
        private Activity mActivity;

        private final ArrayList<String>mItemList;
        private final ArrayList<String>mColorList;
        private ListItemClickListener mItemClickListener;

        public QuizAdapter(Context mContext, Activity mActivity, ArrayList<String>mItemList, ArrayList<String>mColorList){
            this.mContext = mContext;
            this.mActivity = mActivity;
            this.mItemList = mItemList;
            this.mColorList = mColorList;
        }
        public void setItemClickListener(ListItemClickListener itemClickListener){
            this.mItemClickListener = itemClickListener;
        }

        @Override
        public QuizAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        public interface ViewHolder {
        }
    }
    }

    class QuizModel implements Quiz {
        String question;
        ArrayList<String>answers;
        int correctAnswer;
        String questionCategoryId;
        ArrayList<String>backgroundColors;

        public QuizModel(String question, ArrayList<String> answers, int correctAnswer, String questionCategoryId, ArrayList<String> backgroundColors) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.answers = answers;
            this.questionCategoryId = questionCategoryId;
            this.backgroundColors = backgroundColors;
        }
        public  String getQuestion(){
            return question;
        }
        public int getCorrectAnswer(){
            return correctAnswer;
        }
        public ArrayList<String>getAnswers(){
            return answers;
        }
        public String getQuestionCategoryId(){
            return questionCategoryId;
        }
        public void setBackgroundColors(ArrayList<String>backgroundColors){
            this.backgroundColors = backgroundColors;
        }
        public ArrayList<String>getBackGroundColors(){
            return backgroundColors;
        }
        @Override
        public  int describeContents(){
            return 0;
        }
        @Override
        public void writeToParcel(Parcel dest, int flags){
            dest.writeString(question);
            dest.writeList(answers);
            dest.writeInt(correctAnswer);
            dest.writeString(questionCategoryId);
            dest.writeList(backgroundColors);
        }
        protected QuizModel(Parcel in){
            question = in.readString();
            in.readList(answers, QuizModel.class.getClassLoader());
            correctAnswer = in.readInt();
            questionCategoryId = in.readString();
            in.readList(backgroundColors, QuizModel.class.getClassLoader());
        }
        public final Parcelable.Creator<QuizModel> CREATOR = new Parcelable.Creator<QuizModel>() {
            @Override
            public QuizModel createFromParcel(Parcel source){
                return new QuizModel(source);
            }
            @Override
            public QuizModel[] newArray(int size){
                return new QuizModel[size];
            }
        };

    }

    abstract class ListItemClickListener {
        abstract void onItemClick(int position, View view);
    }