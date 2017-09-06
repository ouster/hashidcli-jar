import time

from hashids import Hashids

current_milli_time = int(round(time.time() * 1000))

codes = set()
hashids = Hashids(salt=str(current_milli_time), alphabet='1234567890qwertyuiopasdfghjklzxcvbnm', min_length=6)

incr = 190000000  # INCR command in REDIS?

while 1:
    incr = incr + 1
    hashid=hashids.encode(incr)
    print("incr= "+str(incr)+", hashid="+hashid)

    if hashid in codes:
        print("collision code="+hashid)
        break
    else:
        codes.add(hashid)

print("code set size = "+str(len(codes)))