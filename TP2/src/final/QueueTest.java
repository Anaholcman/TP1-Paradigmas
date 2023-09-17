package queue4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class QueueTest {

  @Test public void test01QueueShouldBeEmptyWhenCreated() {  
    assertTrue( new Queue().isEmpty() );    
  }

  @Test public void test02AddElementsToTheQueue() {  
    assertFalse( new Queue().add( firstAddedObject ).isEmpty() );  
  }
  
  @Test public void test03AddedElementsIsAtHead() {  
    assertEquals( firstAddedObject, new Queue().add( firstAddedObject ).head() );  
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queuewith1object();
    queue.take();
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {  
    assertEquals( firstAddedObject, queuewith1object().take() ); 
  }

  @Test public void test06QueueBehavesFIFO() {
	Queue queue = queuewith2object();

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {  
    assertEquals( queuewith2object().head(), firstAddedObject ); 
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queuewith1object();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {  
    assertEquals( 2, queuewith2object().size() );  
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {	
    errorifEmpty( () -> new Queue().take() );  
  }
  
  @Test public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = queuewith1object();
    queue.take();
	errorifEmpty( () -> queue.take() );
  }

  @Test public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {	
    errorifEmpty( () -> new Queue().head() );  
  }
  
  private String firstAddedObject = "First";
  private String secondAddedObject = "Second";
  private Queue queuewith1object() {	return new Queue().add( firstAddedObject );  }
  private Queue queuewith2object() {	return queuewith1object().add( secondAddedObject );  }
  private void errorifEmpty(Runnable functiontotest) {
		assertEquals( EmptySlot.isempty, assertThrows ( Error.class, () -> functiontotest.run() ) .getMessage() );
	}
}