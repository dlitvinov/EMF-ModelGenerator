package org.eclipse.emf.modelmutator.test;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
import org.eclipse.emf.modelmutator.api.ModelMutator;
import org.eclipse.emf.modelmutator.api.ModelMutatorConfiguration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelChangerTest extends ModelMutatorTest {

	private ProjectSpace projectSpace;

	@Before
	public void beforeTest() {
		projectSpace = createProjectSpace();
		ModelMutatorConfiguration mmc = createModelMutatorConfigurationSeed(projectSpace);

		ModelMutator.generateModel(mmc);
	}

	@After
	public void afterTest() {
		projectSpace = null;
	}

	@Test
	public void testSetAttributesRandom() throws SerializationException {
		ModelMutatorConfiguration mmc = createModelMutatorConfigurationRandom(projectSpace);
		ModelMutator.changeModel(mmc);
		String stringOrg = ModelMutatorHelper.eObjectToString(projectSpace.getProject());
		
		ModelMutatorConfiguration mmc2 = createModelMutatorConfigurationRandom(projectSpace);
		ModelMutator.changeModel(mmc2);
		String stringNew = ModelMutatorHelper.eObjectToString(projectSpace.getProject());
			
		Assert.assertNotSame(stringNew, stringOrg);
	}

	@Test
	public void testSetAttributesSeed() throws SerializationException {
		ModelMutatorConfiguration mmc = createModelMutatorConfigurationSeed(projectSpace);
		ModelMutator.changeModel(mmc);
		String stringOrg = ModelMutatorHelper.eObjectToString(projectSpace.getProject());
		
		ModelMutatorConfiguration mmc2 = createModelMutatorConfigurationSeed(projectSpace);
		ModelMutator.changeModel(mmc2);
		String stringNew = ModelMutatorHelper.eObjectToString(projectSpace.getProject());
		
		Assert.assertEquals(stringNew, stringOrg);
	}
}
