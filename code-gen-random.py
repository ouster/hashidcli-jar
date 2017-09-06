import random
codes = set()
while 1:
    code=''.join(random.choice('1234567890qwertyuiopasdfghjklzxcvbnm')for x in range(8))
    if code in codes:
        print("collision code="+code)
        break
    else:
        codes.add(code)

print("code set size = "+str(len(codes)))
