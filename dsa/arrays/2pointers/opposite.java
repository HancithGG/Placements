You are given a sorted array of integers and a target value.
Return the indices (1-based) of the two numbers such that they add up to the target.
Assume exactly one solution exists.

📥 Input
text
numbers = [2, 7, 11, 15]
target = 9
  
📤 Output
text
[1, 2]

int left = 0;
int right = arr.length - 1;

while (left < right) {

    int sum = arr[left] + arr[right];

    if (sum == target) {
        System.out.println(left + " " + right);
        break;
    }

    else if (sum < target) {
        left++;
    }

    else {
        right--;
    }
}
