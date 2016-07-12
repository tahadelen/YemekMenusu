package com.tahadelen.utils;

import android.content.Context;

import com.tahadelen.connectors.DBService;
import com.tahadelen.datatypes.Category;
import com.tahadelen.datatypes.Food;

public class DatabaseFiller {

	public static void fill(Context context) {
		Food food = new Food();
		DBService database = new DBService(context);

		food.setName("Hünkar Beðendi");
		food.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla orci erat, luctus et hendrerit id, ultrices a nisl. Praesent vestibulum, elit vel dignissim vulputate, ligula felis sagittis turpis, nec tincidunt est diam in dui. Aenean imperdiet suscipit mauris non feugiat. Aliquam et quam ut erat elementum dictum sit amet vel elit. Proin non suscipit enim. Maecenas non arcu enim, et rutrum justo. Vestibulum odio orci, vehicula ac tempus eu, condimentum ut nisl. Pellentesque vel aliquam nisl. Vestibulum pulvinar, metus et scelerisque dignissim, lectus augue pellentesque velit, vitae lacinia turpis dolor consequat purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.");
		food.setPrice(22.5);
		food.setCategory(Category.ANAYEMEKLER.ordinal());
		food.setImagePath("http://rrdelivery.info/img/Menu%20Items/imgs/5788_large.gif");

		database.insert(food);

		food.setName("Izgara Köfte");
		food.setDescription("Proin vulputate adipiscing sollicitudin. Morbi convallis, ante ac luctus ullamcorper, nibh erat cursus purus, non pellentesque ligula est vitae risus. Morbi a lacus sit amet sapien egestas tincidunt id ut augue. Etiam placerat vulputate neque, ultricies ornare lacus vehicula vel. Sed ac molestie justo. Nam tincidunt feugiat nunc, at tincidunt ipsum viverra id. Aenean tempus lorem et ipsum lacinia ultricies. Maecenas consequat consequat luctus. Aenean euismod ornare elit. Etiam tempor purus vel nibh dapibus ac mattis orci consectetur. Duis mi nisl, tincidunt nec sagittis nec, pretium ac tortor. Curabitur blandit ultrices nulla, eu ornare eros sagittis sit amet. Pellentesque at cursus enim. Proin libero quam, venenatis eu mattis nec, aliquam a magna. Donec porttitor turpis nec neque sollicitudin tincidunt.");
		food.setPrice(19.0);
		food.setCategory(Category.ANAYEMEKLER.ordinal());
		food.setImagePath("http://t0.gstatic.com/images?q=tbn:ANd9GcTs-lbr39iHv5KXynSfUxIj4jkymt_JepIOCBp6RJtroyWaSKVfJ_eQDJ7x");

		database.insert(food);

		food.setName("Patlýcan Kebabý");
		food.setDescription("Nulla facilisi. Donec justo libero, fermentum nec aliquam at, consectetur quis lectus. Sed rhoncus dictum augue quis tincidunt. Maecenas id nisl et massa porttitor viverra. Cras condimentum, est id eleifend semper, quam sapien suscipit dui, sagittis gravida purus sapien eget erat. Ut vitae lorem purus, in ultrices metus. Proin tincidunt, tortor non aliquet fringilla, leo libero tincidunt libero, eu condimentum justo eros condimentum orci. Donec augue erat, accumsan nec porttitor vitae, blandit sed arcu. In lacinia congue felis sed porta. Sed posuere lacinia massa, vitae adipiscing leo tempus quis. Cras placerat ipsum pulvinar neque suscipit luctus. Praesent condimentum pharetra metus, rutrum viverra mi tristique nec. Donec congue est orci. Nam vitae enim quis eros commodo egestas. Aenean eget nisl et ante dapibus accumsan.");
		food.setPrice(25.0);
		food.setCategory(Category.ANAYEMEKLER.ordinal());
		food.setImagePath("http://4.bp.blogspot.com/-QOLwJH7gnsw/UFI-4CrZxqI/AAAAAAAAHsU/vN60gms_Tys/s400/berfendber-tokat-mutfa%C4%9F%C4%B1-02-1-400.jpg");

		database.insert(food);

		food.setName("Büryan Kebabý");
		food.setDescription("Nulla facilisi. Donec justo libero, fermentum nec aliquam at, consectetur quis lectus. Sed rhoncus dictum augue quis tincidunt. Maecenas id nisl et massa porttitor viverra. Cras condimentum, est id eleifend semper, quam sapien suscipit dui, sagittis gravida purus sapien eget erat. Ut vitae lorem purus, in ultrices metus. Proin tincidunt, tortor non aliquet fringilla, leo libero tincidunt libero, eu condimentum justo eros condimentum orci. Donec augue erat, accumsan nec porttitor vitae, blandit sed arcu. In lacinia congue felis sed porta. Sed posuere lacinia massa, vitae adipiscing leo tempus quis. Cras placerat ipsum pulvinar neque suscipit luctus. Praesent condimentum pharetra metus, rutrum viverra mi tristique nec. Donec congue est orci. Nam vitae enim quis eros commodo egestas. Aenean eget nisl et ante dapibus accumsan.");
		food.setPrice(21.0);
		food.setCategory(Category.ANAYEMEKLER.ordinal());
		food.setImagePath("http://www.ascibasi.net/yemek-resimleri/Bulgurlu-Kofte.jpg");

		database.insert(food);

		food.setName("Kola");
		food.setDescription("");
		food.setPrice(22.5);
		food.setCategory(Category.SOGUKICECEKLER.ordinal());
		food.setImagePath("http://www.kotusozluk.com/img/2011/01/gazi-kacmis-kola-gibi-hissetmek_10561.jpg");

		database.insert(food);

		food.setName("Ayran");
		food.setDescription("");
		food.setPrice(22.5);
		food.setCategory(Category.SOGUKICECEKLER.ordinal());
		food.setImagePath("http://1.bp.blogspot.com/-dOo6BoZO1Ws/Tz2Uh5ZtGlI/AAAAAAAAC7E/Cb3hxcWrR_I/s1600/ayran_bakir_masraba_bardak.jpg");

		database.insert(food);

		food.setName("Çay");
		food.setDescription("");
		food.setPrice(22.5);
		food.setCategory(Category.SICAKICECEKLER.ordinal());
		food.setImagePath("http://img.haberler.com/haber/344/cay-deyip-gecme-4058344_2510_o.jpg");

		database.insert(food);

		food.setName("Çoban Salata");
		food.setDescription("Domates, soðan, kývýrcýk");
		food.setPrice(22.5);
		food.setCategory(Category.SALATALAR.ordinal());
		food.setImagePath("http://www.ercanusta.com/yonetim/aspjpeg.asp?path=C:%5Cwebspace%5Cclients%5Cercanusta.com%5Cwww%5Cimg%5Ctarifs%5Ctarif71.jpg&width=400");

		database.insert(food);

		food.setName("Ýçli Köfte");
		food.setDescription("Nulla facilisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut faucibus eros a enim ornare at commodo odio lacinia. Nullam ultricies ante et dui congue iaculis. Donec posuere eros vel nisi lacinia quis pretium augue elementum. Phasellus id nisi lacus, sit amet bibendum sem. Morbi ligula nisl, ultricies ac vestibulum at, iaculis varius nisi. Etiam et quam enim. Aenean dictum cursus facilisis. Aenean sodales quam in ipsum mollis egestas. Morbi aliquet lectus quis ipsum elementum vulputate. Mauris ante nisi, viverra sed ullamcorper ac, dapibus eget ligula.");
		food.setPrice(22.5);
		food.setCategory(Category.ARASICAKLAR.ordinal());
		food.setImagePath("https://static.sehirfirsati.com/82/77/1353918957782.jpg");

		database.insert(food);

		food.setName("Profiterol");
		food.setDescription("");
		food.setPrice(22.5);
		food.setCategory(Category.TATLILAR.ordinal());
		food.setImagePath("http://img03.blogcu.com/v2/images/big/m/i/s/missgibiblog/missgibiblog_1334757070198.jpg");

		database.insert(food);

		food.setName("Fýstýklý Baklava");
		food.setDescription("");
		food.setPrice(22.5);
		food.setCategory(Category.TATLILAR.ordinal());
		food.setImagePath("http://img5.resimup.net/di/IE3E.jpg");

		database.insert(food);

		food.setName("Cevizli Baklava");
		food.setDescription("");
		food.setPrice(22.5);
		food.setCategory(Category.TATLILAR.ordinal());
		food.setImagePath("http://t3.gstatic.com/images?q=tbn:ANd9GcRWRL7zN8pU9jH3LT_ZhLJZ5xWUIN4nIVUzMqneJEwbGqHZEW-j_hQRG40lTw");

		database.insert(food);

		food.setName("Hamsi Tava");
		food.setDescription("Nunc id massa in nisi consectetur placerat. Curabitur mi libero, dictum eu auctor at, consequat et mauris. Fusce at tellus erat. Aliquam erat volutpat. Donec commodo tempor purus, sed mollis leo pharetra ut. Maecenas adipiscing sollicitudin libero in vulputate. Proin non augue in est suscipit porttitor. Maecenas euismod rutrum sagittis. Cras sit amet purus ut sapien elementum consequat.");
		food.setPrice(22.5);
		food.setCategory(Category.DENIZURUNLERI.ordinal());
		food.setImagePath("http://img03.blogcu.com/v2/images/big/m/i/s/missgibiblog/missgibiblog_1334757070198.jpg");

		database.insert(food);

		food.setName("Mercimek Çorbasý");
		food.setDescription("Nunc id massa in nisi consectetur placerat. Curabitur mi libero, dictum eu auctor at, consequat et mauris. Fusce at tellus erat. Aliquam erat volutpat. Donec commodo tempor purus, sed mollis leo pharetra ut. Maecenas adipiscing sollicitudin libero in vulputate. Proin non augue in est suscipit porttitor. Maecenas euismod rutrum sagittis. Cras sit amet purus ut sapien elementum consequat.");
		food.setPrice(5);
		food.setCategory(Category.CORBALAR.ordinal());
		food.setImagePath("http://www.hepimizaileyiz.com/Pct/10096/Kremali-Balkabagi-Corbasi");

		database.insert(food);

		food.setName("Ýþkembe Çorbasý");
		food.setDescription("Nunc id massa in nisi consectetur placerat. Curabitur mi libero, dictum eu auctor at, consequat et mauris. Fusce at tellus erat. Aliquam erat volutpat. Donec commodo tempor purus, sed mollis leo pharetra ut. Maecenas adipiscing sollicitudin libero in vulputate. Proin non augue in est suscipit porttitor. Maecenas euismod rutrum sagittis. Cras sit amet purus ut sapien elementum consequat.");
		food.setPrice(5);
		food.setCategory(Category.CORBALAR.ordinal());
		food.setImagePath("http://wowturkey.com/tr456/Necdet_Cevahir_1000.jpg");

		database.insert(food);

		food.setName("Yayla Çorbasý");
		food.setDescription("Nunc id massa in nisi consectetur placerat. Curabitur mi libero, dictum eu auctor at, consequat et mauris. Fusce at tellus erat. Aliquam erat volutpat. Donec commodo tempor purus, sed mollis leo pharetra ut. Maecenas adipiscing sollicitudin libero in vulputate. Proin non augue in est suscipit porttitor. Maecenas euismod rutrum sagittis. Cras sit amet purus ut sapien elementum consequat.");
		food.setPrice(5);
		food.setCategory(Category.CORBALAR.ordinal());
		food.setImagePath("http://www.kalitelihayat.com/images/news/79899.jpg");

		database.insert(food);
	}
}
