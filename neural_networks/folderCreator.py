import os

for i in range(11, 100):
    if not os.path.exists(f"./gen{i}"): 
        # if the demo_folder directory is not present 
        # then create it.
        os.makedirs(f"./gen{i}")