def findMissingAndRepeatedValues(nums):
    n = len(nums)
    count = [0] * (n + 1)  # Create a count list with n+1 elements

    for num in nums:
        count[num] += 1

    missing_value = 0
    repeated_value = 0

    for i in range(1, n + 1):
        if count[i] == 0:
            missing_value = i
        elif count[i] == 2:
            repeated_value = i

    return missing_value, repeated_value

def _driver():
    # Test your function with sample input
    nums = [1, 2, 2, 4] # Example input
    result = findMissingAndRepeatedValues(nums)
    print("Missing value:", result[0])
    print("Repeated value:", result[1])

_driver()
