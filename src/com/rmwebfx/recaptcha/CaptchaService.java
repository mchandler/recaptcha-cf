package com.rmwebfx.recaptcha;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

public class CaptchaService {
	
	public String getCaptcha(String publicKey, String privateKey) {
		ReCaptcha captcha = ReCaptchaFactory.newReCaptcha(publicKey, privateKey, false);
		
		return captcha.createRecaptchaHtml(null, null);
	}
	
	public boolean checkIsValid(String privateKey, String ipAddress, String challenge, String uresponse) {
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey(privateKey);
		
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(ipAddress, challenge, uresponse);
        return reCaptchaResponse.isValid();
	}
	
}