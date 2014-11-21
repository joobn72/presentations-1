package com.codingthearchitecture.component.presentation;

import com.codingthearchitecture.AbstractComponentTestBase;
import com.codingthearchitecture.domain.Country;
import com.codingthearchitecture.domain.Presentation;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PresentationComponentTests extends AbstractComponentTestBase {

    @Test
    public void test_works() {
        List<Presentation> presentations = getPresentationsComponent().getPresentations();
        assertEquals(107, presentations.size());

        assertEquals("agileiceland2014-agility-and-the-essence-of-software-architecture", presentations.get(0).getId());
        assertEquals("sa2008-why-software-projects-fail", presentations.get(106).getId());
    }

    @Test
    public void test_getPresentation_ReturnsAPopulatedPresentationObject_WhenAValidIdIsSpecified() {
        String id = "agileiceland2014-agility-and-the-essence-of-software-architecture";
        Presentation presentation = getPresentationsComponent().getPresentation(id);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        assertEquals("agileiceland2014-agility-and-the-essence-of-software-architecture", presentation.getId());
        assertEquals("Agility and the essence of software architecture", presentation.getTitle());
        assertEquals("Agile Iceland 2014", presentation.getEvent());
        assertEquals("Reykjavik", presentation.getCity());
        assertEquals(new Country("Iceland"), presentation.getCountry());
        assertEquals("Simon Brown", presentation.getAuthor());
        assertEquals("http://www.codingthearchitecture.com/presentations/agileiceland2014-agility-and-the-essence-of-software-architecture", presentation.getPermalink());
        assertEquals("<p>On one hand the software development industry is pushing forward, reinventing the way that we build software, striving for agility and craftsmanship at every turn. On the other though, we're continually forgetting the good of the past and software teams are still failing on an alarmingly regular basis. Software architecture plays a pivotal role in the delivery of successful software yet it’s often neglected. Whether performed by one person or shared amongst the team, the software architecture role exists on even the most agile of teams yet the balance of up front and evolutionary thinking often reflects aspiration rather than reality. By steering away from big up front design and ivory tower architects, many teams now struggle to create a consistent, shared technical vision to work from. This can result in chaos, big balls of mud or software that still fails to meet its goals, despite continuous user involvement.</p><p>This talk will explore the importance of software architecture and the consequences of not thinking about it, before introducing some lightweight techniques to bring the essence of software architecture back into an agile environment. We'll look at creating a shared vision within the development team, effectively communicating that vision and managing technical risk. I'll also share the strategies that I've used to introduce these techniques into agile teams, even those that didn't think that they needed them. Expect collaboration, sketching and plenty of gamestorming.</p>", presentation.getSummary());
        assertEquals("http://static.codingthearchitecture.com/presentations/agileiceland2014-agility-and-the-essence-of-software-architecture.pdf", presentation.getPdf());
        assertEquals(77, presentation.getNumberOfSlides());
        assertEquals("05-Nov-2014", sdf.format(presentation.getDate()));
    }

}
