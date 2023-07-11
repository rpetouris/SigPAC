package Tests;

import Classes.Extractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ExtractorTest {

    @Mock
    Scanner scanner = mock(Scanner.class);

    @Mock
    PDDocument document = mock(PDDocument.class);
    @Test
    public void readPDFTestNull() {
        Extractor extractor = new Extractor(scanner);
        when(scanner.nextLine()).thenReturn("random.pdf");

        PDDocument document = mock(PDDocument.class);

        when(document.isEncrypted()).thenReturn(true);

        assertNull(extractor.readPDF("random.pdf"));
    }

}
