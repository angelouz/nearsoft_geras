package com.nearsoft.task.strings;

import org.junit.Assert;
import org.junit.Test;

import com.nearsoft.task.validators.EmailValidator;
import com.nearsoft.task.validators.PalindromeChecker;

public class StringsProcessing {

    @Test
    public void checkPalindrome() {
        Assert.assertTrue(PalindromeChecker.check("Radar"));
        Assert.assertTrue(PalindromeChecker.check("civic"));
        Assert.assertTrue(PalindromeChecker.check("madam"));
        Assert.assertTrue(PalindromeChecker.check("..."));
        Assert.assertFalse(PalindromeChecker.check("Palindrome"));
        Assert.assertFalse(PalindromeChecker.check("pato"));
        Assert.assertTrue(PalindromeChecker.check("A man, a plan, a canal: Panama."));
        
    }

    @Test
    public void checkEmailAddress() {
        Assert.assertTrue(EmailValidator.check("name@domain.com"));
        Assert.assertTrue(EmailValidator.check("another.name@domain.subdomain.com.mx"));
        Assert.assertFalse(EmailValidator.check("!wrong@mail.com"));
    }
}
