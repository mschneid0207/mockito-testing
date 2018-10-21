package de.mschneid.unittesting.business;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
       when(mock.get(0)).thenReturn("test");
       assertEquals("test", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("test");
        assertEquals("test", mock.get(0));
        assertEquals("test", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        // SUT
        String value = mock.get(0);
        String value2 = mock.get(1);


        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }
}
