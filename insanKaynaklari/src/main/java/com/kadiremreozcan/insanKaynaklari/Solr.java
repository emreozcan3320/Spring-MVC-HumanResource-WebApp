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
		document.addField("expertise", "PHP Framework yap�lar�nda deneyimli, MySQL kullan�m�nda  deneyimli,HTML, CSS, Jquery  konular�nda bilgi sahibi,Web Servisleri konusunda deneyimli (SOAP-REST),Versiyon kontrol sistemi kullan�m�nda deneyimli (Git-SVN),");
		document.addField("job_definition", "G�revlendirme Magento (php-mysql) ve Intershop (java-Oracle) altyap�lar�n� kullanan y�ksek trafikli Online Al��veri� projelerimizde, implementasyon, �zel mod�l geli�tirme ve entegrasyon �al��malar� olacakt�r.\r\n" + 
				"MyraNewMedia, kuruldu�u 2000 y�l�ndan bug�ne, online al��veri� sistemlerinde tasar�mdan yay�nlamaya, t�m s�re�lerde etkin ��z�mler sunmakta ve T�rkiye'nin �nde gelen perakende markalar�na, online al��veri� proje hizmetleri vermektedir.");
		document.addField("personal_qualities", "Yaz�l�m ekibimize, T�rkiye'nin tan�nm�� perakende firmalar�n�n E-Ticaret projelerinde g�revlendirilecek, object oriented PHP programlama konusunda en az 3 y�l deneyimli Developer ve en az 5 y�l deneyimli Senior developer tak�m arkada�lar� ar�yoruz.");
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
