import os
import re
import sys

def fix_svg(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()

    if "fadeInUp" not in content:
        return False

    # Replace keyframes
    content = re.sub(r'@keyframes fadeInUp \{.*?\}', 
                     '@keyframes fadeIn {\n      0% { opacity: 0; }\n      100% { opacity: 1; }\n    }', 
                     content, flags=re.DOTALL)
    
    # Replace animation name
    content = content.replace("animation: fadeInUp", "animation: fadeIn")
    
    with open(filepath, 'w', encoding='utf-8') as f:
        f.write(content)
    return True

target_dir = sys.argv[1]
count = 0
for root, _, files in os.walk(target_dir):
    for file in files:
        if file.endswith('.svg'):
            filepath = os.path.join(root, file)
            if fix_svg(filepath):
                count += 1
                
print(f"Fixed {count} SVG files.")
