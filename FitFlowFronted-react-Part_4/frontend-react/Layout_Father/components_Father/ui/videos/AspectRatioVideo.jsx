import React from "react";

const aspectRatioClassMap = {
  "16/9": "aspect-video",
  "4/3": "aspect-4/3",
  "1/1": "aspect-square",
  "21/9": "aspect-[21/9]",
};

export default function AspectRatioVideo({
  videoUrl,
  aspectRatio = "16/9",
  title = "Embedded Video",
}) {
  const aspectClass = aspectRatioClassMap[aspectRatio] || "aspect-video";

  return (
    <div className={`${aspectClass} overflow-hidden rounded-lg`}>
      <iframe
        src={videoUrl}
        title={title}
        frameBorder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowFullScreen
        className="w-full h-full"
      ></iframe>
    </div>
  );
}

