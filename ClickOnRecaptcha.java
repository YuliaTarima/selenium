		// deal with reCaptcha
		List<WebElement> isPresent = driver
				.findElements(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"));
		if (isPresent.size() > 0) {
			driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"))
					.click();
		}
		System.out.println("clicked recaptcha");

		driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Create Account')]")).click();
