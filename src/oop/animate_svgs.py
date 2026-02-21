import os
import sys
import xml.etree.ElementTree as ET
import re

def inject_animation(filepath):
    try:
        # Read the file as raw text first
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()

        # Simple string replacement strategy is safer for preserving existing structure
        # Add <style> right after <svg ...>
        
        style_block = """
  <style>
    @keyframes fadeInUp {
      0% { opacity: 0; transform: translateY(10px); }
      100% { opacity: 1; transform: translateY(0); }
    }
    .animated-g {
      opacity: 0;
      animation: fadeInUp 0.8s ease-out forwards;
    }
    /* Add sequential delays */
    .animated-g:nth-of-type(1) { animation-delay: 0.1s; }
    .animated-g:nth-of-type(2) { animation-delay: 0.3s; }
    .animated-g:nth-of-type(3) { animation-delay: 0.5s; }
    .animated-g:nth-of-type(4) { animation-delay: 0.7s; }
    .animated-g:nth-of-type(5) { animation-delay: 0.9s; }
    .animated-g:nth-of-type(6) { animation-delay: 1.1s; }
    .animated-g:nth-of-type(7) { animation-delay: 1.3s; }
    .animated-g:nth-of-type(8) { animation-delay: 1.5s; }
    .animated-g:nth-of-type(9) { animation-delay: 1.7s; }
    .animated-g:nth-of-type(10) { animation-delay: 1.9s; }
  </style>
"""

        # Check if already animated
        if "fadeInUp" in content:
            return False

        # Find the <svg> opening tag and insert the style block after it
        match = re.search(r'<svg[^>]+>', content)
        if match:
            insert_pos = match.end()
            content = content[:insert_pos] + style_block + content[insert_pos:]
            
            # Now, replace all top-level <g> tags with <g class="animated-g" ...
            # Wait, nth-of-type only works if they are direct siblings of the same tag type.
            # Using regex to add class="animated-g" to <g> tags.
            content = content.replace('<g ', '<g class="animated-g" ')
            content = content.replace('<g>', '<g class="animated-g">')

            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            return True
        else:
            print(f"Skipping {filepath}: No <svg> tag found.")
            return False

    except Exception as e:
        print(f"Error processing {filepath}: {e}")
        return False

def main():
    if len(sys.argv) != 2:
        print("Usage: python animate_svgs.py <directory_path>")
        sys.exit(1)

    target_dir = sys.argv[1]
    
    if not os.path.isdir(target_dir):
        print(f"Error: {target_dir} is not a valid directory.")
        sys.exit(1)

    count = 0
    for root, _, files in os.walk(target_dir):
        for file in files:
            if file.endswith('.svg'):
                filepath = os.path.join(root, file)
                if inject_animation(filepath):
                    count += 1
                
    print(f"Successfully animated {count} SVG files in {target_dir}.")

if __name__ == "__main__":
    main()
