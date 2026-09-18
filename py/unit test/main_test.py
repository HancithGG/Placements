import pytest
from main import total_xp

@pytest.mark.parametrize(
    "level, xp_to_add, expected",
    [
        (1, 100, 200),
        (2, 250, 450),
        (170, 590, 17590),
        (176, 350, 17950),  # example you mentioned
        (0, 0, 0),          # edge case: no level, no xp
        (5, 0, 500),        # edge case: xp_to_add = 0
    ]
)
def test_total_xp(level, xp_to_add, expected):
    assert total_xp(level, xp_to_add) == expected            # use python -v or -s to run test cases
