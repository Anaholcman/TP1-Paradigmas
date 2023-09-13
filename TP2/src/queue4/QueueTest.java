package queue4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class QueueTest {

  private Queue queuewithsome() {
	return new Queue().add( "Something" );
  }
	
  @Test public void test01QueueShouldBeEmptyWhenCreated() {  assertTrue( new Queue().isEmpty() );  }
  @Test public void test02AddElementsToTheQueue() {  assertFalse( new Queue().add( "Something" ).isEmpty() );  }
  @Test public void test03AddedElementsIsAtHead() {  assertEquals( "Something", new Queue().add( "Something" ).head() );  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = new Queue().add( "Something" );
    queue.take();
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = new Queue();
    String addedObject = "Something";
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = new Queue();
    String firstAddedObject = "First";
    String secondAddedObject = "Second";

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new Queue();
    String firstAddedObject = "First";

    queue.add( firstAddedObject );
    queue.add( "Second" );

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queuewithsome();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {  
    assertEquals( 2, new Queue().add( "First" ).add( "Second" ).size() );  
  }
  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {  
	assertEquals ( EmptySlot.isempty , assertThrows ( Error.class, () -> new Queue().take() ).getMessage() );  
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = queuewithsome();
    queue.take();
    assertEquals ( EmptySlot.isempty, assertThrows ( Error.class, () -> queue.take() ).getMessage() );
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {  
	assertEquals( EmptySlot.isempty, assertThrows ( Error.class, () -> new Queue().head() ) .getMessage() );
  }
}