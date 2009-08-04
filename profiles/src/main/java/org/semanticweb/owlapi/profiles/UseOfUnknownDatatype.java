package org.semanticweb.owlapi.profiles;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;

import java.util.Set;
import java.util.Collections;
/*
 * Copyright (C) 2009, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

/**
 * Author: Matthew Horridge<br>
 * The University of Manchester<br>
 * Information Management Group<br>
 * Date: 03-Aug-2009
 *
 * Use of an unknown datatype. That is, the datatype isn't in the OWL 2 datatype map,
 * the datatype IRI doesn't begin with the xsd: prefix, the datatype isn't rdfs:Literal, and the
 * datatype isn't defined with a DatatypeDefinition axiom
 */
public class UseOfUnknownDatatype extends OWLProfileViolation implements OWL2ProfileViolation {

    private OWLDatatype datatype;

    public UseOfUnknownDatatype(OWLOntology ontology, OWLAxiom axiom, OWLDatatype datatype) {
        super(ontology, Collections.singleton(axiom));
        this.datatype = datatype;
    }

    /**
     * Gets the datatype that is invalid
     * @return The invalid datatype
     */
    public OWLDatatype getDatatype() {
        return datatype;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Use of unknown datatype: ");
        sb.append(datatype);
        sb.append(" [");
        sb.append(getAxiom());
        sb.append(" in ");
        sb.append(getOntologyID());
        sb.append("]");
        return sb.toString();
    }
}
