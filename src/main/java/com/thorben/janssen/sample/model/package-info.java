@AnyMetaDef(name = "CarMetaDef", metaType = "string", idType = "int",
        metaValues = {
                @MetaValue(value = "Honda", targetEntity = Honda.class),
                @MetaValue(value = "BMW", targetEntity = BMW.class)
        }
)
package com.thorben.janssen.sample.model;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;