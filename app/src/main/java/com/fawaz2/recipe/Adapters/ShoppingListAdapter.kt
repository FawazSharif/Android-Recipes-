package com.fawaz2.recipe.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.fawaz2.recipe.Activities.ShoppingListItemsActivity
import com.fawaz2.recipe.Models.ShoppingList
import com.fawaz2.recipe.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class ShoppingListAdapter (val context: Context, val shoppingListFeed: ArrayList<ShoppingList>): BaseAdapter(){
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //To change body of created functions use File | Settings | File Templates.
        var view = convertView
        if(view == null){
            view = layoutInflater.inflate(R.layout.shoppinglist_view, parent, false)
        }


        val shoppingListName = view?.findViewById<TextView>(R.id.ShoppingListName)
        shoppingListName?.text = "Shopping List: ${position}"


        val currentUser = FirebaseAuth.getInstance().currentUser
        var uid: String? = null
        val firebaseInstance = FirebaseDatabase.getInstance()
        if (currentUser != null){
            uid = currentUser.uid
        }
        val firebasedatabase = firebaseInstance!!
            .getReference("/Users/${uid}")
        val postkey = firebasedatabase.key!!

        val postsRef: DatabaseReference = firebasedatabase.child(uid!!)
        val articleID = postsRef.key



        val ingredientsText1 = shoppingListFeed.get(position).strIngredient1
        val ingredientsText2 = shoppingListFeed.get(position).strIngredient2
        val ingredientsText3 = shoppingListFeed.get(position).strIngredient3
        val ingredientsText4 = shoppingListFeed.get(position).strIngredient4
        val ingredientsText5 = shoppingListFeed.get(position).strIngredient5
        val ingredientsText6 = shoppingListFeed.get(position).strIngredient6
        val ingredientsText7 = shoppingListFeed.get(position).strIngredient7
        val ingredientsText8 = shoppingListFeed.get(position).strIngredient8
        val ingredientsText9 = shoppingListFeed.get(position).strIngredient9
        val ingredientsText10 = shoppingListFeed.get(position).strIngredient10
        val ingredientsText11 = shoppingListFeed.get(position).strIngredient11
        val ingredientsText12 = shoppingListFeed.get(position).strIngredient12
        val ingredientsText13 = shoppingListFeed.get(position).strIngredient13
        val ingredientsText14 = shoppingListFeed.get(position).strIngredient14
        val ingredientsText15 = shoppingListFeed.get(position).strIngredient15
        val ingredientsText16 =shoppingListFeed.get(position).strIngredient16
        val ingredientsText17 = shoppingListFeed.get(position).strIngredient17
        val ingredientsText18 = shoppingListFeed.get(position).strIngredient18
        val ingredientsText19 = shoppingListFeed.get(position).strIngredient19
        val ingredientsText20 = shoppingListFeed.get(position).strIngredient20


        view!!.setOnClickListener {
            Toast.makeText(view.context, "Loading...", Toast.LENGTH_SHORT).show()
            val intent = Intent(view.context, ShoppingListItemsActivity::class.java)

            intent.putExtra("INGREDIENTS_1", ingredientsText1)
            intent.putExtra("INGREDIENTS_2", ingredientsText2)
            intent.putExtra("INGREDIENTS_3", ingredientsText3)
            intent.putExtra("INGREDIENTS_4", ingredientsText4)
            intent.putExtra("INGREDIENTS_5", ingredientsText5)
            intent.putExtra("INGREDIENTS_6", ingredientsText6)
            intent.putExtra("INGREDIENTS1_7", ingredientsText7)
            intent.putExtra("INGREDIENTS_8", ingredientsText8)
            intent.putExtra("INGREDIENTS_9", ingredientsText9)
            intent.putExtra("INGREDIENTS_10", ingredientsText10)
            intent.putExtra("INGREDIENTS_11", ingredientsText11)
            intent.putExtra("INGREDIENTS_12", ingredientsText12)
            intent.putExtra("INGREDIENTS_13", ingredientsText13)
            intent.putExtra("INGREDIENTS_14", ingredientsText14)
            intent.putExtra("INGREDIENTS_15", ingredientsText15)
            intent.putExtra("INGREDIENTS_16", ingredientsText16)
            intent.putExtra("INGREDIENTS_17", ingredientsText17)
            intent.putExtra("INGREDIENTS_18", ingredientsText18)
            intent.putExtra("INGREDIENTS_19", ingredientsText19)
            intent.putExtra("INGREDIENTS_20", ingredientsText20)

            view.context.startActivity(intent)

        }

        return view!!
    }

    override fun getItem(position: Int): Any {
        //To change body of created functions use File | Settings | File Templates.
        return shoppingListFeed.get(position)
    }

    override fun getItemId(position: Int): Long {
        //To change body of created functions use File | Settings | File Templates.
        return position.toLong()
    }

    override fun getCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return shoppingListFeed.count()
    }

}