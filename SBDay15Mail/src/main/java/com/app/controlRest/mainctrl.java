package com.app.controlRest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.config.MailConfig;
import com.app.model.DTOMail;
import com.app.service.MailisServ;


@RestController
@RequestMapping("api/mail/")
public class mainctrl {

	@Autowired
	private MailConfig mc;

	@Autowired
	private MailisServ ms;
	
	@PostMapping("kirim")
	public void kirim() {
		mc.send("fitra.akbar@kbbukopin.com", "Coba Kirim Email", "testKirimPesan");
	}
	@PostMapping("kirim2")
	public void kirim2(@RequestBody List<DTOMail> mm) {
		for (DTOMail dm : mm) {
			mc.send(dm.getTo(), dm.getSubject(), dm.getBody());
		}
	}
	
	@PostMapping("kirim3")
	public void kirim3(@RequestBody DTOMail mm) {
		mm.setBody(ms.isipesan().get(0).getIsi());
		mc.send(mm.getTo(), mm.getSubject(), mm.getBody());
}
}