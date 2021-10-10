package com.example.songr;

import com.example.songr.model.albumModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {


	@Test
	public void testAlbum(){
		albumModel newTest= new albumModel("Sahran","Amer",8,1200,"https://1.bp.blogspot.com/-rfB8UeZc8ms/Xx2Of7yqLWI/AAAAAAAADd4/5Qmhv2z5UGEiEEwQeNVHadWzZfyTDkuygCNcBGAsYHQ/w625-h335/fgfdgfd.jpg");
		assertEquals("Sahran",newTest.getTitle());
		newTest.setTitle("set titel");

		newTest.setArtist("Amer");
		assertEquals("Amer", newTest.getArtist());

		newTest.setSongCount(8);
		assertEquals(8, newTest.getSongCount());

		newTest.setLength(1200);
		assertEquals(1200, newTest.getLength());


		newTest.setImageUrl("https://1.bp.blogspot.com/-rfB8UeZc8ms/Xx2Of7yqLWI/AAAAAAAADd4/5Qmhv2z5UGEiEEwQeNVHadWzZfyTDkuygCNcBGAsYHQ/w625-h335/fgfdgfd.jpg");
		assertEquals("https://1.bp.blogspot.com/-rfB8UeZc8ms/Xx2Of7yqLWI/AAAAAAAADd4/5Qmhv2z5UGEiEEwQeNVHadWzZfyTDkuygCNcBGAsYHQ/w625-h335/fgfdgfd.jpg", newTest.getImageUrl());

	}

}
