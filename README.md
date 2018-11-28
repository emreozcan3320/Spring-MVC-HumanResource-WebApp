# Spring-MVC-HumanResource-WebApp

##Giriş,	Amaç	ve	Kapsam
Bu	 belge, 2018 yılı	 OBSS	 Java	 yaz	 stajı	 döneminde	 stajyerlerden	 yapılması	 beklenilen	 çalışma,	
uyulması	gereken	kurallar	ve	çalışma	sonucunu	değerlendirme	ölçütlerini	içermektedir.	

##Proje	Çalışması
Yaz	 stajı	 boyunca	 stajyerlerin	 verilen	 sürede	 bu	 belgede	 belirtilen	 kriterlere	 uygun	 ve	 istenilen	
özellikleri	 sunan	 kapsamı	 sınırlandırılmış	 bir	 “İnsan	 Kaynakları	 İş	 İlanları	 ve	 Başvuruları	 Yönetimi	
Uygulaması”	geliştirmesi	beklenmektedir.

##Kullanılacak	Teknolojiler ve	Kısıtlar
Proje kapsamında	geliştirilecek	uygulamanın	web	tabanlı	olması,	Java	dili ve	web	teknolojileri	(HTML,	
CSS,	JavaScript)	kullanılarak yazılması	ve	Java	platformu	üzerinde	çalışabilir	olma	şartı	aranmaktadır.	
Stajyerler,	bu	genel	kısıt	çerçevesinde	istenen	işlevselliği	sağlayabilmek	için	tercih	ettikleri	ön	yüz	ya	
da	sunucu	tarafı	teknolojileri,	framework’leri	ve	kütüphaneleri	kullanmakta	özgürdür.

##Çalışma	Yöntemi
Stajyerler,	 çalışmalarını	 kendileri	 için	 ayrılan	 alanda	 bireysel	 olarak	 sürdürecektir.	 Çalışma	 sırasında	
internet	 kullanımı	 serbesttir. Ancak	 stajyerlerin	 proje	 geliştirme	 konusunda	 birbirleriyle	
yardımlaşması	ya	da	mesai	saatleri	içinde	veya	dışında	başka kişilerden danışmanlığın	ötesinde	bilfiil	
uygulama	geliştirme	desteği alması	kural	dışı	olup	 tespit	edilmesi	halinde	ilgili	 stajyerlerin	çalışması	
yarışma	kapsamı	dışında	tutulacaktır.

##Uygulama	İşlevleri
Geliştirilecek	uygulamanın	aşağıdaki	işlevselliği	sunması	beklenmektedir:

#Kullanıcı	Profilleri
Uygulamayı	2	tip	kullanıcı	kullanabilir:	IK	Uzmanı	ve	Aday(İş	Başvurusu	Yapan	Kişi)	
Bu	 profillerin	 tanımlanması	 veya	 yönetimi	 için	 ekran	 ve	 fonksiyon	 beklenmemektedir.	 Ancak	
uygulama	fonksiyonları	bu	profillerle	ilişkilidir.

#Authentication
IK	Uzmanları	sisteme	LDAP	Authentication	ile	login	olmalıdır.	Bunun	için	bir	LDAP	server	kurulmalıdır.	
Kullanıcı	tanımları	doğrudan	LDAP	server	üzerine	yapılabilir.	Uygulamada	yeni	kullanıcı	tanımlama	ve	
kullanıcı	yönetimi	için	ekranlar	olmasına	gerek	yoktur.
Adaylar	ise	sisteme	Linked-in	profilleri	ile	login	olmalıdır.

#İlan	Yönetimi
IK	Uzmanları	yeni	ilan	hazırlayabilir.	Hazırladığı	ilanı	aktive	edebilir.	Aktif	bir	ilanı	pasife	çekebilir.	İlan	
hazırlarken	otomatik	olarak	aktif	ve	pasif	olması	için	ileri	tarih	ve	saatler	set	edebilir. 
Her	 bir	 ilanın	 kodu,	 başlığı,	 iş	 tanımı,	 adayda	 bulunması	 beklenen	 kişisel	 ve	 profesyonel	 özellikler,	
aktivasyon	zamanı,	kapanma	zamanı olmalıdır.

#İş	Başvurusu	Yapma
Adaylar	 linked-in	 profilleriyle	 iş	 ilanlarına	 başvuruda	 bulunabilir.	 İlanları	 görmek	 için	 login	 olmaya	
gerek	yoktur.	Ancak	başvuru	sırasında	login	olmak	gerekir.
Aday	 başvuru	 yaptığında	 sistem	 daha	 sonra	 esnek	 aramalarda	 kullanabilmek	 için	 adayın	 detaylı	
linked-in	profil	bilgilerini	sisteme	alıp	kaydetmelidir.

#İş	Başvurularını	Görüntüleme(Aday)
Aday	login	olduğunda	önceki	başvurularının	detaylarını	ve	statusunu	görebilmelidir.

#İş	Başvurularını	Görünütüleme(IK	Uzmanı)
IK	Uzmanı	ilanlar	üzerinden	o	ilana	yapılan	başvuruları	görüntüleyebilir.	Bir	ilana	başvuran	bir	adayın	
başka	 hangi	 ilanlara	 başvurduğunu	 görüntüleyebilir.	 Adayın	 profil	 detaylarını	 görebilir.	 Başvuruyu	
işleme	 alabilir,	 kabul	 veya	 red	 edebilir.	 Bir	 ilana	 yapılan	 başvuruları	 statusune	 göre	 filtreleyebilir.	
Başvuru	statu	değişikliklerinde	sistem,	başvuru	sahibine	uygun	bir	ifade	ile	mail	yoluyla	bilgilendirme	
mesajı	gönderir.	

#Kara	Listeye	Alma
IK	 Uzmanı	 herhangi	 bir	 adayı,	 sebebini	 kayıt	 altına	 alarak	 kara	 listeye	 alabilir.	 Kara	 listeye	 alınan	
adaylar	yeni	iş	başvurusu	yapamaz.	Eski	başvuruları	da	red	edilir.

#Free	Format	Text	Bazlı	Arama
IK	 Uzmanı	 başvuru	 sırasında	 topladığı	 profiller	 üzerinde	 google	 search	 benzeri	 free	 text	 arama	
yapabilir.	Bu	aramayı	bir	ilana	başvuranlar	içinde	yapabileceği	gibi	herhangi	bir	başvurudan	bağımsız	
olarak	 kaydedilen	 tüm	 profiller	 üzerinde	 de	 yapabilir.	 (Bunun	 için	 uygun	 bir	 no-sql	 database,	 	 Solr
veya	Elastic	Search	gibi	alternatiflerin	birinin	veya	bir	kombinasyonunun	kullanımı	beklenmektedir)

#Ekstra	İşlevler
Ekstra	işlevler, geliştirilecek	uygulamada	olması	beklenen	işlevlerin	dışında	olan	ve	değerlendirmeye	
olumlu	 katkısı	 olacak	 işlevlerdir.	 Bu	 işlevlerin	 değerlendirmeye	 katkısı	 olabilmesi	 için	 2.3 altında	
verilen	tüm	işlevlerin	eksiksiz	olarak	gerçeklenmesi	gerekmektedir.

#Başvuruları	Uygunluk	Sırasına	Koyma
Sistem	 bir	 ilana	 yapılan	 yapılan	 başvuruların	 profillerinde	 yer	 alan	 bilgilerle	 ilanda	 yer	 alan	 şartlar	
arasındaki	uyumu	ölçümleyerek	başvuruları	uygunluk	sırasına	koyabilmelidir.

#Diğer	Ekstra	İşlevler
Bu	 dokümanda	 tariflenen	 işlevler	 dışında	 gerçeklenecek	 ek	 işlevler,	 değerlendirmeye	 olumlu	 katkı	
sağlayacaktır.
