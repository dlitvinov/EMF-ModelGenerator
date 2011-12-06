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
 * Class for creating random Short values.
 * 
 * @author Eugen Neufeld
 * @author Stephan K�hler
 * @see AttributeSetter
 */
public class AttributeSetterEShort extends AttributeSetter<Short> {

	/**
	 * Creates a new AttributeSetter for Short attributes.
	 * 
	 * @param random
	 *            Random object used to create attribute values
	 */
	public AttributeSetterEShort(Random random) {
		super(random);
	}

	/**
	 * {@inheritDoc}
	 */
	public Short createNewAttribute() {
		return (short) random.nextInt();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<Short> createNewAttributes(int maxAmount) {
		List<Short> result = new ArrayList<Short>(maxAmount);
		for (int i = 0; i < maxAmount; i++) {
			result.add(createNewAttribute());
		}
		return result;
	}

}
