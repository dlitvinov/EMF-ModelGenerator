/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.modelmutator.intern.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Class for creating random String values.
 * 
 * @author Eugen Neufeld
 * @author Stephan K�hler
 * @see AttributeSetter
 */
public class AttributSetterEString extends AttributeSetter<String> {

	/**
	 * Creates a new AttributeSetter for String attributes.
	 * 
	 * @param random
	 *            Random object used to create attribute values
	 */
	public AttributSetterEString(Random random) {
		super(random);
	}

	/**
	 * {@inheritDoc}
	 */
	public String createNewAttribute() {
		StringBuffer string = new StringBuffer();
		string.delete(0, string.length());
		for (int j = -5; j < random.nextInt(10); j++) {
			string.append((char) (random.nextInt(94) + 33));
		}
		return string.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> createNewAttributes(int maxAmount) {
		List<String> result = new ArrayList<String>(maxAmount);
		for (int i = 0; i < maxAmount; i++) {
			result.add(createNewAttribute());
		}
		return result;
	}

}