/**
 * 
 */
package br.com.caelum.vraptor.sysweb.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anota��o para Autentica��o e Autoriza��o
 * @author fidelis.guimaraes
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Restrito {

}
