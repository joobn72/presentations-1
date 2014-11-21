package com.codingthearchitecture.util;

import com.codingthearchitecture.domain.Presentation;

import java.util.Comparator;

public class PresentationByReverseDateComparator implements Comparator<Presentation> {

    public int compare(Presentation presentation1, Presentation presentation2) {
        if (presentation1 == null || presentation1.getDate() == null) {
            return -1;
        } else if (presentation2 == null || presentation2.getDate() == null) {
            return 1;
        } else {
            int comparison = presentation2.getDate().compareTo(presentation1.getDate());
            if (comparison == 0) {
                // in the event that two presentations have the same date, we'll defer to sorting by title
                return presentation1.getTitle().compareTo(presentation2.getTitle());
            } else {
                return comparison;
            }
        }
    }

}
