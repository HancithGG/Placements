import heapq


def k_smallest(nums, k):

    heap = nums[:]

    heapq.heapify(heap)

    result = []

    for _ in range(k):
        result.append(heapq.heappop(heap))

    return result


def k_largest(nums, k):

    heap = []

    for num in nums:
        heapq.heappush(heap, num)

        if len(heap) > k:
            heapq.heappop(heap)

    return heap


def main():

    nums = [7, 10, 4, 3, 20, 15]
    k = 3

    print(k_smallest(nums, k))


main()
