package fr.unice.polytech.isa.tcf.components;

import arquillian.AbstractTCFTest;

import fr.unice.polytech.isa.tcf.CatalogueExploration;
import fr.unice.polytech.isa.tcf.entities.Cookies;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import javax.ejb.EJB;
import java.util.Set;

import static org.junit.Assert.assertEquals;


@RunWith(Arquillian.class)
public class CatalogueTest extends AbstractTCFTest {

	@EJB private CatalogueExploration catalogue;

	@Test
	public void preMadeRecipesAreAVailable() {
		Set<Cookies> premade = catalogue.listPreMadeRecipes();
		assertEquals(3, premade.size());
	}

	@Test
	public void regexpExploration() {
		Assert.assertEquals(0, catalogue.exploreCatalogue("unknown").size());
		Assert.assertEquals(2, catalogue.exploreCatalogue("CHOCO").size());
		Assert.assertEquals(1, catalogue.exploreCatalogue(Cookies.DARK_TEMPTATION.name()).size());
	}

}
