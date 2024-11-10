import time

def fibonacci_recursive(n):
    if n <= 1:
        return n
    else:
        return fibonacci_recursive(n-1) + fibonacci_recursive(n-2)

def fibonacci_iterative(n):
    if n <= 1:
        return n
    a, b = 0, 1
    for _ in range(2, n+1):
        a, b = b, a + b
    return b

def measure_execution_time(func, n):
    start_time = time.time()
    result = func(n)
    end_time = time.time()
    execution_time_ms = (end_time - start_time) * 1000
    return result, execution_time_ms

if __name__ == '__main__':
    n = int(input("Enter a number: ")) # You can change this value to test with other numbers

    # Measure execution time for recursive approach
    fib_recursive_result, fib_recursive_time = measure_execution_time(fibonacci_recursive, n)
    
    # Measure execution time for iterative approach
    fib_iterative_result, fib_iterative_time = measure_execution_time(fibonacci_iterative, n)
    print(f"Fibonacci number at position {n} (recursive): {fib_recursive_result} (Execution time: {fib_recursive_time:.3f} ms)")
    print(f"Fibonacci number at position {n} (iterative): {fib_iterative_result} (Execution time: {fib_iterative_time:.3f} ms)")