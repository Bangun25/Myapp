package dota.draftdota2.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import dota.draftdota2.Adapter.CounterItem;
import dota.draftdota2.Adapter.HeroItem;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "draftdota2";

    // Nama Table
    private static final String TABLE_HERO = "hero";
    private static final String TABLE_COUNTER = "counter_hero";



    // NamaKolom Table Hero
    private static final String KEY_ID_COUNTER = "id_hero";
    private static final String KEY_NAMA_HERO= "nama_hero";
    private static final String KEY_ABILITY_HERO = "ability_hero";
    private static final String KEY_ROLE_HERO = "role_hero";
    private static final String KEY_TYPE_ATTACK= "attack_type";
    private static final String KEY_DAMAGE_HERO= "damage_hero";
    private static final String KEY_HP_HERO = "hp_hero";
    private static final String KEY_MP_HERO= "mp_hero";
    private static final String KEY_SPEED_HERO = "speed_hero";
    private static final String KEY_GAMBAR = "gambar";

    // NamaKolom Table counter_hero
    private static final String KEY_COUNTER_ID = "id_counter";
    private static final String KEY_COUNTER_1 = "counter_1";
    private static final String KEY_GAMBAR_1 = "gambar_1";
    private static final String KEY_COUNTER_2 = "counter_2";
    private static final String KEY_GAMBAR_2 = "gambar_3";
    private static final String KEY_COUNTER_3 = "counter_3";
    private static final String KEY_GAMBAR_3 = "gambar_3";


    // Membuat table Hero

    private static final String CREATE_TABLE_HERO = " CREATE TABLE "
            + TABLE_DETAIL + "("
            + KEY_ID_HERO + " INTEGER PRIMARY KEY,"
            + KEY_NAMA_HERO + " TEXT,"
            + KEY_ABILITY_HERO + " TEXT,"
            + KEY_ROLE_HERO + "TEXT"
            + KEY_TYPE_ATTACK + " TEXT,"
            + KEY_DAMAGE_HERO + " TEXT,"
            + KEY_HP_HERO + " TEXT,"
            + KEY_MP_HERO + " TEXT,"
            + KEY_SPEED_HERO + " TEXT,"
            + KEY_GAMBAR + " TEXT" + ")";

    // Membuat table counter_hero

    private static final String CREATE_TABLE_COUNTER_HERO = " CREATE TABLE "
            + TABLE_COUNTER_HERO + "("
            + KEY_COUNTER_ID + " INTEGER PRIMARY KEY,"
            + KEY_COUNTER_1 + " TEXT,"
            + KEY_GAMBAR_1 + " TEXT,"
            + KEY_COUNTER_2 + " TEXT,"
            + KEY_GAMBAR_2 + " TEXT,"
            + KEY_COUNTER_3 + " TEXT,"
            + KEY_GAMBAR_3 + " TEXT" +")";


    // Membuat Versi Database
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create SQLITE

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HERO);
        db.execSQL(CREATE_TABLE_COUNTER_HERO);

    }

    // Update SQLITE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTER_HERO);
        onCreate(db);
    }


    // Tambah data detail_hero
    public void addHero(HeroItem Hero) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_HERO, hero.getId_hero());
        values.put(KEY_NAMA_HERO, hero.getNama_hero());
        values.put(KEY_ABILITY_HERO, hero.getAbility_hero());
        values.put(KEY_ROLE_HERO, hero.getRole_hero());
        values.put(KEY_TYPE_HERO, hero.getType_attack());
        values.put(KEY_DAMAGE_HERO, hero.getDamage_hero());
        values.put(KEY_HP_HERO, hero.getHp_hero());
        values.put(KEY_MP_HERO, hero.getMp_hero());
        values.put(KEY_SPEED_HERO, hero.getSpeed_hero());
        values.put(KEY_GAMBAR, hero.getGambar());


        // Inserting Row
        db.insert(TABLE_HERO, null, values);
        db.close();
    }

    // Tambah data counter_hero
    public void addCounter(CounterItem counterHero) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_COUNTER, counterHero.getHero_id());
        values.put(KEY_COUNTER_1, counterHero.getCounter_1());
        values.put(KEY_GAMBAR_1, counterHero.getGambar_1());
        values.put(KEY_COUNTER_2, counterHero.getCounter_2());
        values.put(KEY_GAMBAR_2, counterHero.getGambar_2());
        values.put(KEY_COUNTER_3, counterHero.getCounter_3());
        values.put(KEY_GAMBAR_3, counterHero.getGamabar_3());

        // Inserting Row
        db.insert(TABLE_COUNTER_HERO, null, values);
        db.close();
    }




    // Get Semua Detail Hero
    public List<Item> getHero() {
        List<HeroItem> detailList = new ArrayList<HeroItem>();

        String query_select_hero = "SELECT * FROM " + TABLE_HERO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query_select_hero, null);

        if (cursor.moveToFirst()) {
            do {
                HeroItem Hero = new HeroItem(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9));
                detailList.add(Hero);
            } while (cursor.moveToNext());
        }
        return detailList;
    }


    //get data counter
    public List<CounterItem> getCounter(String id_counter) {
        List<CounterItem> counterList = new ArrayList<CounterItem>();

        String query_select_counter_hero = "SELECT * FROM " + TABLE_COUNTER_HERO;
        if (id_counter != null)
            query_select_counter_hero += " WHERE id_hero = '" + id_counter
                    + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query_select_counter_hero, null);

        if (cursor.moveToFirst()) {
            do {
                CounterItem counterHero = new CounterItem(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getString(6));
                counterList.add(counterHero);
            } while (cursor.moveToNext());
        }
        return counterList;
    }


    //get counter1
    public CounterItem getCounter1() {

        String selectQuery = "SELECT * FROM " + TABLE_COUNTER + " WHERE " + KEY_COUNTER_ID + " = '2'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        CounterItem counterItem = new CounterItem();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            counterItem.setId_hero(cursor.getInt(0));
            counterItem.setCounter_1(cursor.getInt(1));
            counterItem.setCounter_1(cursor.getString(2));
            counterItem.setCounter_2(cursor.getInt(3));
            counterItem.setCounter_1(cursor.getString(4));
            counterItem.setCounter_3(cursor.getInt(5));
            counterItem.setGambar_3(cursor.getString(6));

            cursor.close();
        } else {
            counterItem = null;
        }
        db.close();
        return counterItem;
    }

    public void deleteData() {
        SQLiteDatabase db = this.getWritableDatabase();

        String delete_hero = "DELETE FROM " + TABLE_HERO;
        String delete_counter_hero = "DELETE FROM " + TABLE_COUNTER_HERO;


        db.execSQL(delete_hero);
        db.execSQL(delete_counter_hero);


        db.close();
    }

}
