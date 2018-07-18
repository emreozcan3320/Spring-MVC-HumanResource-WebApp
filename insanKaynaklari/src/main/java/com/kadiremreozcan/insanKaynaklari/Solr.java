package com.kadiremreozcan.insanKaynaklari;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;

import com.kadiremreozcan.entity.Jobs;
import com.kadiremreozcan.service.JobsService;

public class Solr {
	public static void main(String[] args) {
		/*
		JobsService jobService = new JobsService();
		ArrayList<Jobs> isler = jobService.getAll();
		
		System.out.println(isler);
		/*
		
		String urlString = "http://localhost:8983/solr/jobs";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());

		SolrInputDocument document = new SolrInputDocument();
		
		document.addField("id", "5");
		document.addField("expertise", "PHP Framework yapýlarýnda deneyimli, MySQL kullanýmýnda  deneyimli,HTML, CSS, Jquery  konularýnda bilgi sahibi,Web Servisleri konusunda deneyimli (SOAP-REST),Versiyon kontrol sistemi kullanýmýnda deneyimli (Git-SVN),");
		document.addField("job_definition", "Görevlendirme Magento (php-mysql) ve Intershop (java-Oracle) altyapýlarýný kullanan yüksek trafikli Online Alýþveriþ projelerimizde, implementasyon, özel modül geliþtirme ve entegrasyon çalýþmalarý olacaktýr.\r\n" + 
				"MyraNewMedia, kurulduðu 2000 yýlýndan bugüne, online alýþveriþ sistemlerinde tasarýmdan yayýnlamaya, tüm süreçlerde etkin çözümler sunmakta ve Türkiye'nin önde gelen perakende markalarýna, online alýþveriþ proje hizmetleri vermektedir.");
		document.addField("personal_qualities", "Yazýlým ekibimize, Türkiye'nin tanýnmýþ perakende firmalarýnýn E-Ticaret projelerinde görevlendirilecek, object oriented PHP programlama konusunda en az 3 yýl deneyimli Developer ve en az 5 yýl deneyimli Senior developer takým arkadaþlarý arýyoruz.");
		document.addField("title", "PHP Developer");
		
		try {
			solr.add(document);
			solr.commit();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*
		try {
			solr.deleteById("1");
			solr.commit();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	

	}
	
}
