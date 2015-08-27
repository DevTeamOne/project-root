package datamanagement;

import java.util.function.Function;

/**
 * This class implements a domain specific language(dsl)
 * for a Weight Range using a fluent interface. 
 */
public class WeightRange {
    private Function<String, Integer> expression = x -> -1;
    private float value = -1;

    
    
    private WeightRange(){
    }
    
    
    
    /**
     * Mutator, setting an expression to be computed for the
     * upper bound of the range.
     * 
     * @param expression, a lambda expression for computing the upper bound.
     * @return the current object to use as a fluent interface.
     */
    public WeightRange withUpperBoundExpression(Function<String, Integer> expression) {
      this.expression = expression;
      return this;
    }
    
    
    
    /**
     * Mutator for value under test.
     * @param value, the value to compare.
     * 
     * @return the current object to use as a fluent interface.
     */
    public WeightRange testValue(float value) {
      this.value = value;
      return this;
    }
    
    
    
    /**
     * is Inside Lower Bound checks if the value is greater than zero.
     * 
     * @return true if value is greater than zero.
     */
    public boolean isInsideLowerBound() {
      return value >= 0;
    }
    
    
    
    /**
     * Executes the upper bound expression against the value and
     * returns true if the expression result is greater.
     * 
     * @return true if the value is less than the upper bound.
     */
    public boolean isInsideUpperBound() {
      return value <= expression.apply("");
    }
    
    
    
    /**
     * Checks if the error message is within the range of the upper and
     * lower bounds.
     * 
     * @param errorMessage, The message to throw if it is not within bounds.
     * @return true, if the error is within bounds.
     * @throws RuntimeException, if not within bounds.
     */
    public boolean isWithinBounds(String errorMessage) {
      boolean bounded = isInsideLowerBound() && isInsideUpperBound();
      if(!bounded)
        throw new RuntimeException(errorMessage);
      return bounded;
    }
    
    
    
    /**
     * Class method, gets an instance of the WeightRange class.
     * 
     * @return An empty instance of WeightRange.
     */
    public static WeightRange getInstance() {
      return new WeightRange();
    }
  }