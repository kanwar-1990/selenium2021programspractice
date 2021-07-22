package ImpSeleniumSession;

public class CsspathSelector {

	public static void main(String[] args) {
		/*
		 * 
		 * id: #{id} #username input[id=username] input[id=username][type='email']
		 * input#username
		 * 
		 * 
		 * //class.{classname} .login-email
		 * .form-control.private-form__control.login-email input.login-email
		 * button.uiButton-- we can do like this also----tagname.classname---this will
		 * give class
		 * 
		 * //text input[id^='username']-- text starts with input[id^='user']
		 * input[id$='username']-- text ends with input[id$='name'] //contains
		 * input[id*='username'] parent selector div>input#username
		 * div.private-form__input-wrapper>input#username
		 * 
		 * CSS selector vs xpath CSS selector -- are bit faster than xpath since it want
		 * travese from top of the DOM , it will try to find directly 
		 * xpath-- will travese from top of the DOM, BUT things like
		 * ancestor,following-preceding,sibling are not avaiable in css selector which
		 * can help in complex webtables
		 * 
		 */

	}

}
